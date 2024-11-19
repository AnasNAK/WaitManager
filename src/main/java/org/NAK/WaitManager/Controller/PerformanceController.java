package org.NAK.WaitManager.Controller;

import org.NAK.WaitManager.Enum.Status;
import org.NAK.WaitManager.Service.contract.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/stats")
public class PerformanceController {
    @Autowired
    private VisitService visitService;

    @GetMapping("/performance/{waitingListId}")
    public ResponseEntity<Map<String ,Double>> getPerformanceIndicators(@PathVariable Long waitingListId) {
        Map<String ,Double> performanceIndicators = visitService.generatePerformanceIndicators(waitingListId);
        return ResponseEntity.ok(performanceIndicators);
    }

    @GetMapping("/status-distribution/{waitingListId}")
    public ResponseEntity<Map<Status , Long>> getVisitStatusDistribution(@PathVariable Long waitingListId) {
        Map<Status,Long> statusDistribution = visitService.calculateVisitorStatusDistribution(waitingListId);
        return ResponseEntity.ok(statusDistribution);
    }
}
