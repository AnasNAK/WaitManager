package org.NAK.WaitManager.Mapper;


import org.NAK.WaitManager.DTO.Visit.CreateVisitDTO;
import org.NAK.WaitManager.DTO.Visit.ResponseVisitDTO;
import org.NAK.WaitManager.DTO.Visit.UpdateVisitDTO;
import org.NAK.WaitManager.Entity.Visit;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VisitMapper {

    Visit toVisit(CreateVisitDTO createVisitDTO);

    Visit toVisit(UpdateVisitDTO updateVisitDTO);

    ResponseVisitDTO toResponseVisitDTO(Visit visit);


}
