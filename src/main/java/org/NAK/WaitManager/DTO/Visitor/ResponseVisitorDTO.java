package org.NAK.WaitManager.DTO.Visitor;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseVisitorDTO {

    private Long id;
    private String firstName;
    private String lastName;
}
