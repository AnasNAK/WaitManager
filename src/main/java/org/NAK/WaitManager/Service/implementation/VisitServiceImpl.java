package org.NAK.WaitManager.Service.implementation;

import jakarta.persistence.EntityNotFoundException;
import org.NAK.WaitManager.DTO.Visit.CreateVisitDTO;
import org.NAK.WaitManager.DTO.Visit.ResponseVisitDTO;
import org.NAK.WaitManager.DTO.Visit.UpdateVisitDTO;
import org.NAK.WaitManager.Entity.Embeded.EmbeddedIds;
import org.NAK.WaitManager.Entity.Visit;
import org.NAK.WaitManager.Entity.Visitor;
import org.NAK.WaitManager.Entity.WaitingList;
import org.NAK.WaitManager.Mapper.VisitMapper;
import org.NAK.WaitManager.Repository.VisitRepository;
import org.NAK.WaitManager.Repository.VisitorRepository;
import org.NAK.WaitManager.Repository.WaitingListRepository;
import org.NAK.WaitManager.Service.contract.VisitService;
import org.NAK.WaitManager.Util.Algorithm;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VisitServiceImpl implements VisitService {

    private final VisitMapper visitMapper;
    private final VisitRepository visitRepository;
    private final VisitorRepository visitorRepository;
    private final WaitingListRepository waitingListRepository;


    public VisitServiceImpl(VisitMapper visitMapper, VisitRepository visitRepository ,VisitorRepository visitorRepository ,WaitingListRepository waitingListRepository) {
        this.visitMapper = visitMapper;
        this.visitRepository = visitRepository;
        this.visitorRepository = visitorRepository;
        this.waitingListRepository = waitingListRepository;
    }

    @Override
    public ResponseVisitDTO saveVisit(CreateVisitDTO createVisitDTO) {
        System.out.println("Received DTO: " + createVisitDTO);

        Visitor visitor = visitorRepository.findById(createVisitDTO.getVisitorId())
                .orElseThrow(() -> new EntityNotFoundException("Visitor not found with ID: " + createVisitDTO.getVisitorId()));

        WaitingList waitingList = waitingListRepository.findById(createVisitDTO.getWaitingListId())
                .orElseThrow(() -> new EntityNotFoundException("Waiting List not found with ID: " + createVisitDTO.getWaitingListId()));

        long currentVisitCount = visitRepository.countByWaitingListId(createVisitDTO.getWaitingListId());

        if (currentVisitCount >= waitingList.getCapacity()) {
            throw new IllegalStateException("Cannot create visit: waiting list capacity reached");
        }

        Visit visit = visitMapper.toVisit(createVisitDTO);

        visit.setVisitor(visitor);
        visit.setWaitingList(waitingList);

        visitRepository.save(visit);

        return visitMapper.toResponseVisitDTO(visit);
    }



    @Override
    public ResponseVisitDTO updateVisit(UpdateVisitDTO updateVisitDTO) {
        EmbeddedIds embeddedIds = new EmbeddedIds(
                updateVisitDTO.getVisitorId(),
                updateVisitDTO.getWaitingListId()
        );

        Visit existingVisit = visitRepository.findByVisitorIdAndWaitingListId(embeddedIds.getVisitorId(), embeddedIds.getWaitingListId())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Visit not found with visitorId: " + embeddedIds.getVisitorId() +
                                " and waitingListId: " + embeddedIds.getWaitingListId()
                ));

        Visit updatedVisit = visitMapper.toVisit(updateVisitDTO);

        visitRepository.save(updatedVisit);

        return visitMapper.toResponseVisitDTO(updatedVisit);
    }

    @Override
    public ResponseVisitDTO findVisitById(EmbeddedIds embeddedIds) {
        Visit visit = visitRepository.findByVisitorIdAndWaitingListId(embeddedIds.getVisitorId(), embeddedIds.getWaitingListId())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Visit not found with visitorId: " + embeddedIds.getVisitorId() +
                                " and waitingListId: " + embeddedIds.getWaitingListId()
                ));
        return visitMapper.toResponseVisitDTO(visit);
    }

    @Override
    public void deleteVisit(EmbeddedIds embeddedIds) {
        Visit visitToDelete = visitRepository.findByVisitorIdAndWaitingListId(embeddedIds.getVisitorId(), embeddedIds.getWaitingListId())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Visit not found with visitorId: " + embeddedIds.getVisitorId() +
                                " and waitingListId: " + embeddedIds.getWaitingListId()
                ));
        visitRepository.delete(visitToDelete);
    }

    @Override
    public List<ResponseVisitDTO> findAllVisits() {
        List<Visit> allVisits = visitRepository.findAll();
        return allVisits.stream()
                .map(visitMapper::toResponseVisitDTO)
                .toList();
    }

    @Override
    public List<ResponseVisitDTO> getScheduledVisits(long waitingListId) {
        String schedulingAlgorithm = waitingListRepository.findById(waitingListId)
                .orElseThrow(() -> new EntityNotFoundException("Waiting List not found with ID: " + waitingListId))
                .getAlgorithm();

        List<Visit> visits = visitRepository.findByWaitingListId(waitingListId);

        List<Visit> scheduledVisits = Algorithm.schedule(visits, schedulingAlgorithm);

        return scheduledVisits.stream()
                .map(visitMapper::toResponseVisitDTO)
                .collect(Collectors.toList());
    }

}
