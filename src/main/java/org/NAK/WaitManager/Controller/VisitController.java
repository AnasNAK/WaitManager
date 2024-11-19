package org.NAK.WaitManager.Controller;

import jakarta.validation.Valid;
import org.NAK.WaitManager.DTO.Visit.CreateVisitDTO;
import org.NAK.WaitManager.DTO.Visit.ResponseVisitDTO;
import org.NAK.WaitManager.DTO.Visit.UpdateVisitDTO;
import org.NAK.WaitManager.Entity.Embeded.EmbeddedIds;
import org.NAK.WaitManager.Service.contract.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visits")
public class VisitController {

    private final VisitService visitService;

    @Autowired
    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }

    @PostMapping
    public ResponseEntity<ResponseVisitDTO> createVisit(@Valid @RequestBody CreateVisitDTO createVisitDTO) {
        System.out.println("Received DTO: " + createVisitDTO);
        ResponseVisitDTO responseVisitDTO = visitService.saveVisit(createVisitDTO);
        return new ResponseEntity<>(responseVisitDTO, HttpStatus.CREATED);
    }


    @PutMapping("/{visitorId}/{waitingListId}")
    public ResponseEntity<ResponseVisitDTO> updateVisit(@PathVariable Long visitorId,
                                                        @PathVariable Long waitingListId,
                                                        @Valid @RequestBody UpdateVisitDTO updateVisitDTO,
                                                        BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(null);
        }

        updateVisitDTO.setVisitorId(visitorId);
        updateVisitDTO.setWaitingListId(waitingListId);

        ResponseVisitDTO updatedVisit = visitService.updateVisit(updateVisitDTO);
        return new ResponseEntity<>(updatedVisit, HttpStatus.OK);
    }

    @GetMapping("/{visitorId}/{waitingListId}")
    public ResponseEntity<ResponseVisitDTO> getVisit(@PathVariable Long visitorId, @PathVariable Long waitingListId) {
        EmbeddedIds embeddedIds = new EmbeddedIds(visitorId, waitingListId);
        ResponseVisitDTO visit = visitService.findVisitById(embeddedIds);
        if (visit != null) {
            return new ResponseEntity<>(visit, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{visitorId}/{waitingListId}")
    public ResponseEntity<Void> deleteVisit(@PathVariable Long visitorId, @PathVariable Long waitingListId) {
        EmbeddedIds embeddedIds = new EmbeddedIds(visitorId, waitingListId);
        visitService.deleteVisit(embeddedIds);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<ResponseVisitDTO>> getAllVisits() {
        List<ResponseVisitDTO> allVisits = visitService.findAllVisits();
        if (allVisits.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(allVisits, HttpStatus.OK);
    }

    @GetMapping("/scheduled/{waitingListId}")
    public List<ResponseVisitDTO> getScheduledVisits(@PathVariable long waitingListId) {
        return visitService.getScheduledVisits(waitingListId);
    }
}
