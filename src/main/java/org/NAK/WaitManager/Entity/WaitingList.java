package org.NAK.WaitManager.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
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
    private Set<Visit> visits = new HashSet<>();



}
