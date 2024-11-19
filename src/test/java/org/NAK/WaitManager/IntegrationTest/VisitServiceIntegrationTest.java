package org.NAK.WaitManager.IntegrationTest;

import jakarta.transaction.Transactional;
import org.NAK.WaitManager.DTO.Visit.CreateVisitDTO;
import org.NAK.WaitManager.DTO.Visit.ResponseVisitDTO;
import org.NAK.WaitManager.Enum.Status;
import org.NAK.WaitManager.Service.contract.VisitService;
import org.NAK.WaitManager.WaitManagerApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = WaitManagerApplication.class)
@ActiveProfiles("sit")
@Transactional
public class VisitServiceIntegrationTest {

    @Autowired
    private VisitService visitService;

    @Test
    public void testSaveVisit() {

        CreateVisitDTO createVisitDTO = new CreateVisitDTO();

        createVisitDTO.setVisitorId(1L);
        createVisitDTO.setWaitingListId(2L);

        createVisitDTO.setArrivalTime(LocalDateTime.parse("2024-11-18T00:00:00"));
        createVisitDTO.setStartTime(LocalDateTime.parse("2024-11-18T00:00:00"));
        createVisitDTO.setEndTime(LocalDateTime.parse("2024-11-18T00:00:00"));

        createVisitDTO.setPriority(1);
        createVisitDTO.setEstimatedProcessTime(30);
        createVisitDTO.setStatus(Status.FINISHED);

        ResponseVisitDTO savedVisit = visitService.saveVisit(createVisitDTO);

        assertNotNull(savedVisit);
        assertEquals(createVisitDTO.getVisitorId(), savedVisit.getVisitorId());
        assertEquals(createVisitDTO.getWaitingListId(), savedVisit.getWaitingListId());
        assertEquals(createVisitDTO.getPriority(), savedVisit.getPriority());
        assertEquals(createVisitDTO.getArrivalTime(), savedVisit.getArrivalTime());
        assertEquals(createVisitDTO.getStartTime(), savedVisit.getStartTime());
        assertEquals(createVisitDTO.getEndTime(), savedVisit.getEndTime());
        assertEquals(createVisitDTO.getEstimatedProcessTime(), savedVisit.getEstimatedProcessTime());
    }
}
