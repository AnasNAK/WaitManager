package org.NAK.WaitManager.DTO.WaitingList;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateWaitingListDTO {

    @NotBlank
    private LocalDate date;

    @NotBlank
    private String algorithm;

    @NotBlank
    private Integer capacity;


}
