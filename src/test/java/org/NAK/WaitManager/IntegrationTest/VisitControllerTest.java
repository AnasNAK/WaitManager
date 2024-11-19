package org.NAK.WaitManager.IntegrationTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.NAK.WaitManager.Controller.VisitController;
import org.NAK.WaitManager.DTO.Visit.CreateVisitDTO;
import org.NAK.WaitManager.DTO.Visit.ResponseVisitDTO;
import org.NAK.WaitManager.DTO.Visit.UpdateVisitDTO;
import org.NAK.WaitManager.DTO.Visitor.ResponseVisitorSharedDTO;
import org.NAK.WaitManager.DTO.WaitingList.ResponseWaitingListSharedDTO;
import org.NAK.WaitManager.Enum.Status;
import org.NAK.WaitManager.Service.contract.VisitService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(VisitController.class)
@ActiveProfiles("sit")
public class VisitControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VisitService visitService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testSaveVisit() throws Exception {
        CreateVisitDTO createVisitDTO = new CreateVisitDTO();
        createVisitDTO.setVisitorId(1L);
        createVisitDTO.setWaitingListId(2L);
        createVisitDTO.setArrivalTime(LocalDateTime.parse("2024-11-18T00:00:00"));
        createVisitDTO.setStartTime(LocalDateTime.parse("2024-11-18T01:00:00"));
        createVisitDTO.setEndTime(LocalDateTime.parse("2024-11-18T02:00:00"));
        createVisitDTO.setPriority(1);
        createVisitDTO.setEstimatedProcessTime(30);
        createVisitDTO.setStatus(Status.FINISHED);

        ResponseVisitorSharedDTO visitorDTO = new ResponseVisitorSharedDTO();
        visitorDTO.setId(1L);
        visitorDTO.setFirstName("anas");
        visitorDTO.setLastName("nak");

        ResponseWaitingListSharedDTO waitingListDTO = new ResponseWaitingListSharedDTO();
        waitingListDTO.setId(2L);
        waitingListDTO.setDate(LocalDate.parse("2024-11-18"));
        waitingListDTO.setAlgorithm("FIFO");
        waitingListDTO.setCapacity(50);

        ResponseVisitDTO responseVisitDTO = new ResponseVisitDTO();
        responseVisitDTO.setVisitor(visitorDTO);
        responseVisitDTO.setWaitingList(waitingListDTO);
        responseVisitDTO.setArrivalTime(createVisitDTO.getArrivalTime());
        responseVisitDTO.setStartTime(createVisitDTO.getStartTime());
        responseVisitDTO.setEndTime(createVisitDTO.getEndTime());
        responseVisitDTO.setPriority(createVisitDTO.getPriority());
        responseVisitDTO.setEstimatedProcessTime(createVisitDTO.getEstimatedProcessTime());
        responseVisitDTO.setStatus(createVisitDTO.getStatus());

        Mockito.when(visitService.saveVisit(any(CreateVisitDTO.class))).thenReturn(responseVisitDTO);

        mockMvc.perform(post("/api/visits")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createVisitDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.visitor.id").value(1))
                .andExpect(jsonPath("$.waitingList.id").value(2))
                .andExpect(jsonPath("$.status").value("FINISHED"));

        Mockito.verify(visitService, Mockito.times(1)).saveVisit(any(CreateVisitDTO.class));
    }

    @Test
    public void testUpdateVisit() throws Exception {
        UpdateVisitDTO updateVisitDTO = new UpdateVisitDTO();
        updateVisitDTO.setVisitorId(1L);
        updateVisitDTO.setWaitingListId(2L);
        updateVisitDTO.setArrivalTime(LocalDateTime.parse("2024-11-18T01:00:00"));
        updateVisitDTO.setStartTime(LocalDateTime.parse("2024-11-18T02:00:00"));
        updateVisitDTO.setEndTime(LocalDateTime.parse("2024-11-18T03:00:00"));
        updateVisitDTO.setPriority(2);
        updateVisitDTO.setEstimatedProcessTime(45);
        updateVisitDTO.setStatus(Status.FINISHED);

        ResponseVisitDTO responseVisitDTO = new ResponseVisitDTO();
        responseVisitDTO.setArrivalTime(updateVisitDTO.getArrivalTime());
        responseVisitDTO.setStartTime(updateVisitDTO.getStartTime());
        responseVisitDTO.setEndTime(updateVisitDTO.getEndTime());
        responseVisitDTO.setPriority(updateVisitDTO.getPriority());
        responseVisitDTO.setEstimatedProcessTime(updateVisitDTO.getEstimatedProcessTime());
        responseVisitDTO.setStatus(updateVisitDTO.getStatus());

        Mockito.when(visitService.updateVisit(any(UpdateVisitDTO.class))).thenReturn(responseVisitDTO);

        mockMvc.perform(put("/api/visits/1/2")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updateVisitDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("FINISHED"))
                .andExpect(jsonPath("$.priority").value(2));

        Mockito.verify(visitService, Mockito.times(1)).updateVisit(any(UpdateVisitDTO.class));
    }


    @Test
    public void testGetVisit() throws Exception {
        ResponseVisitDTO responseVisitDTO = new ResponseVisitDTO();
        responseVisitDTO.setStatus(Status.FINISHED);

        Mockito.when(visitService.findVisitById(any())).thenReturn(responseVisitDTO);

        mockMvc.perform(get("/api/visits/1/2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("FINISHED"));

        Mockito.verify(visitService, Mockito.times(1)).findVisitById(any());
    }

    @Test
    public void testDeleteVisit() throws Exception {
        Mockito.doNothing().when(visitService).deleteVisit(any());

        mockMvc.perform(delete("/api/visits/1/2"))
                .andExpect(status().isNoContent());

        Mockito.verify(visitService, Mockito.times(1)).deleteVisit(any());
    }

    @Test
    public void testGetAllVisits() throws Exception {
        ResponseVisitDTO visitDTO = new ResponseVisitDTO();
        visitDTO.setStatus(Status.FINISHED);

        Mockito.when(visitService.findAllVisits()).thenReturn(Collections.singletonList(visitDTO));

        mockMvc.perform(get("/api/visits"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(1));

        Mockito.verify(visitService, Mockito.times(1)).findAllVisits();
    }

    @Test
    public void testGetScheduledVisits() throws Exception {
        ResponseVisitDTO visitDTO = new ResponseVisitDTO();
        visitDTO.setStatus(Status.FINISHED);

        Mockito.when(visitService.getScheduledVisits(2L)).thenReturn(Collections.singletonList(visitDTO));

        mockMvc.perform(get("/api/visits/scheduled/2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(1));

        Mockito.verify(visitService, Mockito.times(1)).getScheduledVisits(2L);
    }
}
