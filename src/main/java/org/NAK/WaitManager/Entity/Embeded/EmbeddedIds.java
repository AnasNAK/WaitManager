package org.NAK.WaitManager.Entity.Embeded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class EmbeddedIds {

    @Column(name = "visitorId")
    private Long visitorId;

    @Column(name = "waitingListId")
    private Long waitingListId;

}
