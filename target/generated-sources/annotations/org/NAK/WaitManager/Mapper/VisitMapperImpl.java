package org.NAK.WaitManager.Mapper;

import javax.annotation.processing.Generated;
import org.NAK.WaitManager.DTO.Visit.CreateVisitDTO;
import org.NAK.WaitManager.DTO.Visit.ResponseVisitDTO;
import org.NAK.WaitManager.DTO.Visit.UpdateVisitDTO;
import org.NAK.WaitManager.Entity.Visit;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-18T16:41:15+0100",
    comments = "version: 1.6.2, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class VisitMapperImpl implements VisitMapper {

    @Override
    public Visit toVisit(CreateVisitDTO createVisitDTO) {
        if ( createVisitDTO == null ) {
            return null;
        }

        Visit visit = new Visit();

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

        return visit;
    }

    @Override
    public ResponseVisitDTO toResponseVisitDTO(Visit visit) {
        if ( visit == null ) {
            return null;
        }

        ResponseVisitDTO responseVisitDTO = new ResponseVisitDTO();

        responseVisitDTO.setStartTime( visit.getStartTime() );
        responseVisitDTO.setEndTime( visit.getEndTime() );
        responseVisitDTO.setStatus( visit.getStatus() );
        responseVisitDTO.setPriority( visit.getPriority() );
        responseVisitDTO.setEstimatedProcessTime( visit.getEstimatedProcessTime() );

        return responseVisitDTO;
    }
}
