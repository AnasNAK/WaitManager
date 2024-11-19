package org.NAK.WaitManager.DTO.WaitingList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseWaitingListSharedDTO {
    private Long id;

    private LocalDate date;

    private String algorithm;

    private Integer capacity;


}
