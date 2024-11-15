package org.NAK.WaitManager.Mapper;

import javax.annotation.processing.Generated;
import org.NAK.WaitManager.DTO.WaitingList.CreateWaitingListDTO;
import org.NAK.WaitManager.DTO.WaitingList.ResponseWaitingListDTO;
import org.NAK.WaitManager.DTO.WaitingList.UpdateWaitingListDTO;
import org.NAK.WaitManager.Entity.WaitingList;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-15T16:03:44+0100",
    comments = "version: 1.6.2, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class WaitingListMapperImpl implements WaitingListMapper {

    @Override
    public ResponseWaitingListDTO toResponseWaitingListDTO(WaitingList waitingList) {
        if ( waitingList == null ) {
            return null;
        }

        ResponseWaitingListDTO responseWaitingListDTO = new ResponseWaitingListDTO();

        responseWaitingListDTO.setId( waitingList.getId() );
        responseWaitingListDTO.setDate( waitingList.getDate() );
        responseWaitingListDTO.setAlgorithm( waitingList.getAlgorithm() );
        responseWaitingListDTO.setCapacity( waitingList.getCapacity() );

        return responseWaitingListDTO;
    }

    @Override
    public WaitingList toWaitingList(CreateWaitingListDTO createWaitingListDTO) {
        if ( createWaitingListDTO == null ) {
            return null;
        }

        WaitingList waitingList = new WaitingList();

        waitingList.setDate( createWaitingListDTO.getDate() );
        waitingList.setAlgorithm( createWaitingListDTO.getAlgorithm() );
        waitingList.setCapacity( createWaitingListDTO.getCapacity() );

        return waitingList;
    }

    @Override
    public WaitingList toWaitingList(UpdateWaitingListDTO updateWaitingListDTO) {
        if ( updateWaitingListDTO == null ) {
            return null;
        }

        WaitingList waitingList = new WaitingList();

        waitingList.setDate( updateWaitingListDTO.getDate() );
        waitingList.setAlgorithm( updateWaitingListDTO.getAlgorithm() );
        waitingList.setCapacity( updateWaitingListDTO.getCapacity() );

        return waitingList;
    }
}
