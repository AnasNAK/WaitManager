package org.NAK.WaitManager.Entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "waitingList")
public class WaitingList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "algorithm")
    private String algorithm;

    @Column(name = "capacity")
    private Integer capacity;

    @OneToMany(mappedBy = "waitingList" ,fetch = FetchType.EAGER)
    private List<Visit> visits ;


}
