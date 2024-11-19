package org.NAK.WaitManager.Mapper;

import org.NAK.WaitManager.DTO.Visit.CreateVisitDTO;
import org.NAK.WaitManager.DTO.Visit.ResponseVisitDTO;
import org.NAK.WaitManager.DTO.Visit.UpdateVisitDTO;
import org.NAK.WaitManager.Entity.Visit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {VisitorMapper.class, WaitingListMapper.class})
public interface VisitMapper {

    @Mapping(target = "embeddedIds.visitorId", source = "visitorId")
    @Mapping(target = "embeddedIds.waitingListId", source = "waitingListId")
    Visit toVisit(CreateVisitDTO createVisitDTO);

    @Mapping(target = "embeddedIds.visitorId", source = "visitorId")
    @Mapping(target = "embeddedIds.waitingListId", source = "waitingListId")
    Visit toVisit(UpdateVisitDTO updateVisitDTO);

    @Mapping(target = "visitor", source = "visitor")
    @Mapping(target = "waitingList", source = "waitingList")
    ResponseVisitDTO toResponseVisitDTO(Visit visit);
}
