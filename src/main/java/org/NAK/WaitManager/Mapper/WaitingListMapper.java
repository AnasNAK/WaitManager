package org.NAK.WaitManager.Mapper;

import org.NAK.WaitManager.DTO.WaitingList.CreateWaitingListDTO;
import org.NAK.WaitManager.DTO.WaitingList.ResponseWaitingListDTO;
import org.NAK.WaitManager.DTO.WaitingList.UpdateWaitingListDTO;
import org.NAK.WaitManager.Entity.WaitingList;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WaitingListMapper {

    ResponseWaitingListDTO toResponseWaitingListDTO(WaitingList waitingList);

    WaitingList toWaitingList(CreateWaitingListDTO createWaitingListDTO);

    WaitingList toWaitingList(UpdateWaitingListDTO updateWaitingListDTO);
}
