package org.NAK.WaitManager.Service.implementation;

import org.NAK.WaitManager.DTO.WaitingList.CreateWaitingListDTO;
import org.NAK.WaitManager.DTO.WaitingList.ResponseWaitingListDTO;
import org.NAK.WaitManager.DTO.WaitingList.UpdateWaitingListDTO;
import org.NAK.WaitManager.Entity.WaitingList;
import org.NAK.WaitManager.Mapper.WaitingListMapper;
import org.NAK.WaitManager.Repository.WaitingListRepository;
import org.NAK.WaitManager.Service.contract.WaitingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaitingListServiceImpl implements WaitingListService {

    private final WaitingListRepository waitingListRepository;

    private final WaitingListMapper waitingListMapper;

    @Autowired
    public WaitingListServiceImpl(WaitingListRepository waitingListRepository, WaitingListMapper waitingListMapper) {
        this.waitingListRepository = waitingListRepository;
        this.waitingListMapper = waitingListMapper;
    }


    @Override
    public ResponseWaitingListDTO saveWaitingList(CreateWaitingListDTO createWaitingListDTO) {

        WaitingList waitingList = waitingListMapper.toWaitingList(createWaitingListDTO);
        WaitingList savedWaitingList = waitingListRepository.save(waitingList);
        return waitingListMapper.toResponseWaitingListDTO(savedWaitingList);

    }

    @Override
    public ResponseWaitingListDTO getWaitingList(long id) {
        return null;
    }

    @Override
    public ResponseWaitingListDTO updateWaitingList(long id, UpdateWaitingListDTO updateWaitingListDTO) {
        return null;
    }

    @Override
    public void deleteWaitingList(long id) {

    }

    @Override
    public List<ResponseWaitingListDTO> getWaitingLists() {
        return List.of();
    }
}
