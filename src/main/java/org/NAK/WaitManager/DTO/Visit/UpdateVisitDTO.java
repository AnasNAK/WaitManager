package org.NAK.WaitManager.DTO.Visit;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.NAK.WaitManager.Enum.Status;

import java.time.LocalDate;

public class UpdateVisitDTO {

    private LocalDate arrivalDate;
    private LocalDate startTime;
    private LocalDate endTime;
    @NotNull
    private Status status;
    @Min(0)
    @Max(255)
    private Integer priority;
    private Integer estimatedProcessTime;
}
