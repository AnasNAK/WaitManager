package org.NAK.WaitManager.Controller;

import org.NAK.WaitManager.DTO.Visit.CreateVisitDTO;
import org.NAK.WaitManager.DTO.Visitor.CreateVisitorDTO;
import org.NAK.WaitManager.DTO.Visitor.ResponseVisitorDTO;
import org.NAK.WaitManager.Service.contract.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/visitors")
public class VisitorController {

    private final VisitorService visitorService;

    @Autowired
    public VisitorController(VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    @PostMapping
    public ResponseEntity<ResponseVisitorDTO> createVisit(@RequestBody CreateVisitorDTO createVisitorDTO) {
        ResponseVisitorDTO visitor = visitorService.saveVisitor(createVisitorDTO);
        return ResponseEntity.ok(visitor);

    }

    @GetMapping
    public List<ResponseVisitorDTO> getAllVisits() {
        return visitorService.getVisitors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseVisitorDTO> getVisitById(@PathVariable("id") Long id) {
        ResponseVisitorDTO visitorDTO = visitorService.getVisitor(id);
        return ResponseEntity.ok(visitorDTO);
    }

    @PutMapping("/{id}")
    public
}
