package org.NAK.WaitManager.DTO.Visit;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.NAK.WaitManager.DTO.Visitor.ResponseVisitorSharedDTO;
import org.NAK.WaitManager.DTO.WaitingList.ResponseWaitingListSharedDTO;
import org.NAK.WaitManager.Enum.Status;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseVisitDTO {

    private ResponseVisitorSharedDTO visitor;
    private ResponseWaitingListSharedDTO waitingList;

    private LocalDateTime arrivalTime;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Status status;
    private Integer priority;
    private Integer estimatedProcessTime;
}
