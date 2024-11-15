package org.NAK.WaitManager.Entity.Embeded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class EmbeddedIds {

    @Column(name = "visitorId")
    private Long visitorId;

    @Column(name = "waitingListId")
    private Long waitingListId;

}
