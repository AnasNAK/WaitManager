package org.NAK.WaitManager.Entity.Embeded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;  // Ensure you have Lombok imported

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmbeddedIds implements Serializable {

    @Column(name = "visitorId")
    private Long visitorId;

    @Column(name = "waitingListId")
    private Long waitingListId;
}
