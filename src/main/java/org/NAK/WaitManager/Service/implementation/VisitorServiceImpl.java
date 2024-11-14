package org.NAK.WaitManager.Service.implementation;

import jakarta.persistence.EntityNotFoundException;
import org.NAK.WaitManager.DTO.Visitor.CreateVisitorDTO;
import org.NAK.WaitManager.DTO.Visitor.ResponseVisitorDTO;
import org.NAK.WaitManager.DTO.Visitor.UpdateVisitorDTO;
import org.NAK.WaitManager.Entity.Visitor;
import org.NAK.WaitManager.Mapper.VisitorMapper;
import org.NAK.WaitManager.Repository.VisitorRepository;
import org.NAK.WaitManager.Service.contract.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VisitorServiceImpl implements VisitorService {

    private final VisitorRepository visitorRepository;

    private final VisitorMapper visitorMapper;

    @Autowired
    public VisitorServiceImpl(VisitorRepository visitorRepository, VisitorMapper visitorMapper) {
        this.visitorRepository = visitorRepository;
        this.visitorMapper = visitorMapper;
    }

    @Override
    public ResponseVisitorDTO saveVisitor(CreateVisitorDTO createVisitorDTO) {
        Visitor visitor = visitorMapper.toVisitor(createVisitorDTO);
        visitorRepository.save(visitor);
        return visitorMapper.toResponseVisitorDTO(visitor);
    }

    @Override
    public ResponseVisitorDTO updateVisitor(Long id, UpdateVisitorDTO updateVisitorDTO) {

        Visitor existedVisitor = visitorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Visitor"+ id));
        Visitor updatedVisitor = visitorMapper.toVisitor(updateVisitorDTO);
        updatedVisitor.setId(existedVisitor.getId());
        visitorRepository.save(updatedVisitor);
        return visitorMapper.toResponseVisitorDTO(updatedVisitor);
    }

    @Override
    public ResponseVisitorDTO getVisitor(Long id) {
        return visitorRepository.findById(id)
                .map(visitorMapper::toResponseVisitorDTO)
                .orElseThrow(() -> new EntityNotFoundException("Visitor"+ id));
    }

    @Override
    public void deleteVisitor(Long id) {
        if (!visitorRepository.existsById(id)) {
            throw new EntityNotFoundException("Visitor"+ id);
        }
        visitorRepository.deleteById(id);
    }

    @Override
    public List<ResponseVisitorDTO> getVisitors() {
        return visitorRepository.findAll()
                .stream()
                .map(visitorMapper::toResponseVisitorDTO)
                .collect(Collectors.toList());
    }
}
