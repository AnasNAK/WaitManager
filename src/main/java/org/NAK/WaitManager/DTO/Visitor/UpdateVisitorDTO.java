package org.NAK.WaitManager.DTO.Visitor;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateVisitorDTO {
    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;
}
