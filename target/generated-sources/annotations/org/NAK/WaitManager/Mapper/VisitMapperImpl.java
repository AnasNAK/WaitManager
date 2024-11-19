package org.NAK.WaitManager.Mapper;

import javax.annotation.processing.Generated;
import org.NAK.WaitManager.DTO.Visit.CreateVisitDTO;
import org.NAK.WaitManager.DTO.Visit.ResponseVisitDTO;
import org.NAK.WaitManager.DTO.Visit.UpdateVisitDTO;
import org.NAK.WaitManager.DTO.Visitor.ResponseVisitorSharedDTO;
import org.NAK.WaitManager.DTO.WaitingList.ResponseWaitingListSharedDTO;
import org.NAK.WaitManager.Entity.Embeded.EmbeddedIds;
import org.NAK.WaitManager.Entity.Visit;
import org.NAK.WaitManager.Entity.Visitor;
import org.NAK.WaitManager.Entity.WaitingList;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-19T11:34:10+0100",
    comments = "version: 1.6.2, compiler: javac, environment: Java 23 (Oracle Corporation)"
)
@Component
public class VisitMapperImpl implements VisitMapper {

    @Override
    public Visit toVisit(CreateVisitDTO createVisitDTO) {
        if ( createVisitDTO == null ) {
            return null;
        }

        Visit visit = new Visit();

        visit.setEmbeddedIds( createVisitDTOToEmbeddedIds( createVisitDTO ) );
        visit.setArrivalTime( createVisitDTO.getArrivalTime() );
        visit.setStartTime( createVisitDTO.getStartTime() );
        visit.setEndTime( createVisitDTO.getEndTime() );
        visit.setStatus( createVisitDTO.getStatus() );
        visit.setPriority( createVisitDTO.getPriority() );
        visit.setEstimatedProcessTime( createVisitDTO.getEstimatedProcessTime() );

        return visit;
    }

    @Override
    public Visit toVisit(UpdateVisitDTO updateVisitDTO) {
        if ( updateVisitDTO == null ) {
            return null;
        }

        Visit visit = new Visit();

        visit.setEmbeddedIds( updateVisitDTOToEmbeddedIds( updateVisitDTO ) );
        visit.setArrivalTime( updateVisitDTO.getArrivalTime() );
        visit.setStartTime( updateVisitDTO.getStartTime() );
        visit.setEndTime( updateVisitDTO.getEndTime() );
        visit.setStatus( updateVisitDTO.getStatus() );
        visit.setPriority( updateVisitDTO.getPriority() );
        visit.setEstimatedProcessTime( updateVisitDTO.getEstimatedProcessTime() );

        return visit;
    }

    @Override
    public ResponseVisitDTO toResponseVisitDTO(Visit visit) {
        if ( visit == null ) {
            return null;
        }

        ResponseVisitDTO responseVisitDTO = new ResponseVisitDTO();

        responseVisitDTO.setVisitor( visitorToResponseVisitorSharedDTO( visit.getVisitor() ) );
        responseVisitDTO.setWaitingList( waitingListToResponseWaitingListSharedDTO( visit.getWaitingList() ) );
        responseVisitDTO.setArrivalTime( visit.getArrivalTime() );
        responseVisitDTO.setStartTime( visit.getStartTime() );
        responseVisitDTO.setEndTime( visit.getEndTime() );
        responseVisitDTO.setStatus( visit.getStatus() );
        responseVisitDTO.setPriority( visit.getPriority() );
        responseVisitDTO.setEstimatedProcessTime( visit.getEstimatedProcessTime() );

        return responseVisitDTO;
    }

    protected EmbeddedIds createVisitDTOToEmbeddedIds(CreateVisitDTO createVisitDTO) {
        if ( createVisitDTO == null ) {
            return null;
        }

        EmbeddedIds embeddedIds = new EmbeddedIds();

        embeddedIds.setVisitorId( createVisitDTO.getVisitorId() );
        embeddedIds.setWaitingListId( createVisitDTO.getWaitingListId() );

        return embeddedIds;
    }

    protected EmbeddedIds updateVisitDTOToEmbeddedIds(UpdateVisitDTO updateVisitDTO) {
        if ( updateVisitDTO == null ) {
            return null;
        }

        EmbeddedIds embeddedIds = new EmbeddedIds();

        embeddedIds.setVisitorId( updateVisitDTO.getVisitorId() );
        embeddedIds.setWaitingListId( updateVisitDTO.getWaitingListId() );

        return embeddedIds;
    }

    protected ResponseVisitorSharedDTO visitorToResponseVisitorSharedDTO(Visitor visitor) {
        if ( visitor == null ) {
            return null;
        }

        ResponseVisitorSharedDTO responseVisitorSharedDTO = new ResponseVisitorSharedDTO();

        responseVisitorSharedDTO.setId( visitor.getId() );
        responseVisitorSharedDTO.setFirstName( visitor.getFirstName() );
        responseVisitorSharedDTO.setLastName( visitor.getLastName() );

        return responseVisitorSharedDTO;
    }

    protected ResponseWaitingListSharedDTO waitingListToResponseWaitingListSharedDTO(WaitingList waitingList) {
        if ( waitingList == null ) {
            return null;
        }

        ResponseWaitingListSharedDTO responseWaitingListSharedDTO = new ResponseWaitingListSharedDTO();

        responseWaitingListSharedDTO.setId( waitingList.getId() );
        responseWaitingListSharedDTO.setDate( waitingList.getDate() );
        responseWaitingListSharedDTO.setAlgorithm( waitingList.getAlgorithm() );
        responseWaitingListSharedDTO.setCapacity( waitingList.getCapacity() );

        return responseWaitingListSharedDTO;
    }
}
