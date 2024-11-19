package org.NAK.WaitManager.DTO.Visit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.NAK.WaitManager.Enum.Status;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseVisitSharedDTO {

    private Long visitorId;
    private Long waitingListId;

    private LocalDateTime arrivalTime;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Status status;
    private Integer priority;
    private Integer estimatedProcessTime;
}
