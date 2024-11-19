package org.NAK.WaitManager.Service.implementation;


import jakarta.persistence.EntityNotFoundException;
import org.NAK.WaitManager.DTO.WaitingList.CreateWaitingListDTO;
import org.NAK.WaitManager.DTO.WaitingList.ResponseWaitingListDTO;
import org.NAK.WaitManager.DTO.WaitingList.UpdateWaitingListDTO;
import org.NAK.WaitManager.Entity.WaitingList;
import org.NAK.WaitManager.Mapper.WaitingListMapper;
import org.NAK.WaitManager.Repository.WaitingListRepository;
import org.NAK.WaitManager.Service.contract.WaitingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WaitingListServiceImpl implements WaitingListService {

    private final WaitingListRepository waitingListRepository;

    private final WaitingListMapper waitingListMapper;

    @Value("${DEFAULT_ALGORITHM}")
    private String defaultAlgorithm;

    @Value("${DEFAULT_CAPACITY}")
    private Integer defaultCapacity;


    @Autowired
    public WaitingListServiceImpl(WaitingListRepository waitingListRepository, WaitingListMapper waitingListMapper) {
        this.waitingListRepository = waitingListRepository;
        this.waitingListMapper = waitingListMapper;
    }


    @Override
    public ResponseWaitingListDTO saveWaitingList(CreateWaitingListDTO createWaitingListDTO) {

        WaitingList waitingList = waitingListMapper.toWaitingList(createWaitingListDTO);
        validationAlgoAndCap(waitingList);
        WaitingList savedWaitingList = waitingListRepository.save(waitingList);
        return waitingListMapper.toResponseWaitingListDTO(savedWaitingList);

    }

    @Override
    public ResponseWaitingListDTO getWaitingList(long id) {
        return waitingListRepository.findById(id)
                .map(waitingListMapper::toResponseWaitingListDTO)
                .orElseThrow(() -> new EntityNotFoundException("WaitingList with id :"+ id + "not found"));
    }

    @Override
    public ResponseWaitingListDTO updateWaitingList( UpdateWaitingListDTO updateWaitingListDTO ,long id) {

        WaitingList existedWaitingList = waitingListRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("WaitingList with id :"+ id + "not found"));
        WaitingList waitingList = waitingListMapper.toWaitingList(updateWaitingListDTO);
        waitingList.setId(existedWaitingList.getId());
        validationAlgoAndCap(waitingList);
        waitingListRepository.save(waitingList);
        return waitingListMapper.toResponseWaitingListDTO(waitingList);
    }

    @Override
    public void deleteWaitingList(long id) {
        if (!waitingListRepository.existsById(id)) {
            throw new EntityNotFoundException("WaitingList with ID " + id + " not found");
        }
        waitingListRepository.deleteById(id);
    }


    @Override
    public List<ResponseWaitingListDTO> getWaitingLists() {
        return waitingListRepository.findAll()
                .stream()
                .map(waitingListMapper::toResponseWaitingListDTO)
                .collect(Collectors.toList());
    }


    private WaitingList validationAlgoAndCap(WaitingList waitingList){

        if (waitingList.getAlgorithm() == null) {
            waitingList.setAlgorithm(defaultAlgorithm);
        }
        if (waitingList.getCapacity() == null) {
            waitingList.setCapacity(defaultCapacity);
        }

        return waitingList;
    }
}
