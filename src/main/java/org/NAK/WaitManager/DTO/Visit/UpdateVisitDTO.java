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
public class UpdateVisitDTO {

    @NotNull
    private Long visitorId;

    @NotNull
    private Long waitingListId;

    private LocalDateTime arrivalTime;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    @NotNull
    private Status status;
    @Min(0)
    @Max(255)
    private Integer priority;
    private Integer estimatedProcessTime;
}
