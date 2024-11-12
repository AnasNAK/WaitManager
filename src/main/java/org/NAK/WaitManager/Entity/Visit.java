package org.NAK.WaitManager.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.NAK.WaitManager.Entity.Embeded.EmbeddedIds;
import org.NAK.WaitManager.Enum.Status;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "visit")
public class Visit {

    @EmbeddedId
    private EmbeddedIds embeddedIds;

    @Column
    private LocalDate arrivalTime;

    @Column(name = "startTime")
    private LocalDate startTime;

    @Column(name = "endTime")
    private LocalDate endTime;

    @Column(name = "status")
    private Status status;

    @Column(name = "priority")
    private Integer priority;

    @Column(name = "estimatedProcessTime")
    private Integer estimatedProcessTime;


    @ManyToOne(cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
    @MapsId("visitorId")
    private Visitor visitor;

    @ManyToOne(cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
    @MapsId("waitingListId")
    private WaitingList waitingList;

}
