package org.NAK.WaitManager.DTO.WaitingList;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseWaitingListDTO {

    private Long id;

    private LocalDate date;

    private String algorithm;

    private Integer capacity;
}
