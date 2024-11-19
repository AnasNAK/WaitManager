package org.NAK.WaitManager.Controller;

import org.NAK.WaitManager.DTO.WaitingList.CreateWaitingListDTO;
import org.NAK.WaitManager.DTO.WaitingList.ResponseWaitingListDTO;
import org.NAK.WaitManager.DTO.WaitingList.UpdateWaitingListDTO;
import org.NAK.WaitManager.Service.contract.WaitingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/waitingLists")
public class WaitingListController {

private final WaitingListService waitingListService;

@Autowired
    public WaitingListController(WaitingListService waitingListService) {
    this.waitingListService = waitingListService;
}

@GetMapping
    public List<ResponseWaitingListDTO> getWaitingLists() {
    return waitingListService.getWaitingLists();
}

@PostMapping
    public ResponseEntity<ResponseWaitingListDTO> createWaitingList(@RequestBody CreateWaitingListDTO createWaitingListDTO) {
    ResponseWaitingListDTO createdWaitingList = waitingListService.saveWaitingList(createWaitingListDTO);
    return  ResponseEntity.ok(createdWaitingList);
}

@GetMapping("/{id}")
    public ResponseEntity<ResponseWaitingListDTO> getWaitingListById(@PathVariable Long id) {
    ResponseWaitingListDTO waitingList = waitingListService.getWaitingList(id);
    return  ResponseEntity.ok(waitingList);

}

@PutMapping("/{id}")
    public ResponseEntity<ResponseWaitingListDTO> updateWaitingList(@PathVariable Long id, @RequestBody UpdateWaitingListDTO updateWaitingListDTO) {
    ResponseWaitingListDTO updatedWaitingList = waitingListService.updateWaitingList(updateWaitingListDTO,id);
    return  ResponseEntity.ok(updatedWaitingList);

}
@DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWaitingList(@PathVariable("id") Long id) {
    waitingListService.deleteWaitingList(id);
    return ResponseEntity.noContent().build();

}



}
