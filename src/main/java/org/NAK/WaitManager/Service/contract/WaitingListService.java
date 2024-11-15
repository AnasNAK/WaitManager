package org.NAK.WaitManager.Service.contract;

import org.NAK.WaitManager.DTO.WaitingList.CreateWaitingListDTO;
import org.NAK.WaitManager.DTO.WaitingList.ResponseWaitingListDTO;
import org.NAK.WaitManager.DTO.WaitingList.UpdateWaitingListDTO;

import java.util.List;

public interface WaitingListService {

    ResponseWaitingListDTO saveWaitingList (CreateWaitingListDTO createWaitingListDTO);
    ResponseWaitingListDTO getWaitingList (long id);
    ResponseWaitingListDTO updateWaitingList (UpdateWaitingListDTO updateWaitingListDTO ,long id);
    void deleteWaitingList (long id);
    List<ResponseWaitingListDTO> getWaitingLists();
}
