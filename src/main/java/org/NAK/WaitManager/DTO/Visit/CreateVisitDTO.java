package org.NAK.WaitManager.DTO.Visit;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.NAK.WaitManager.Enum.Status;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateVisitDTO {

    @NotNull(message = "Visitor ID must not be null.")
    private Long visitorId;

    @NotNull(message = "Waiting list ID must not be null.")
    private Long waitingListId;

    private LocalDateTime arrivalTime;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    @NotNull(message = "Status must not be null.")
    private Status status;

    @Min(value = 0, message = "Priority must be between 0 and 255.")
    @Max(value = 255, message = "Priority must be between 0 and 255.")
    private Integer priority;

    private Integer estimatedProcessTime;
}
