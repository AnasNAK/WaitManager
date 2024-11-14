package org.NAK.WaitManager.Controller;

import org.NAK.WaitManager.DTO.Visit.CreateVisitDTO;

import org.NAK.WaitManager.DTO.Visitor.ResponseVisitorDTO;
import org.NAK.WaitManager.Service.contract.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/visitors")
public class VisitController {
    private final VisitorService visitorService;

    @Autowired
    public VisitController(VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    @PostMapping
    public ResponseEntity<CreateVisitDTO> createVisit(@RequestBody CreateVisitDTO createVisitDTO) {
        ResponseVisitorDTO visitor = visitorService.saveVisitor(createVisitDTO);

    }

}
