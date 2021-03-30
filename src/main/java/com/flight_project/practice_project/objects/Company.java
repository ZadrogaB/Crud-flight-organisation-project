package com.flight_project.practice_project.objects;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Company {

    @Id
    @Column(name = "Id", nullable = false, unique = true)
    private Long id;

    @Column(name = "Name", unique = true, nullable = false)
    private String companyName;

    @Column(name = "Station", nullable = false)
    private String station;

    @OneToMany (
            targetEntity = Aeroplanes.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Aeroplanes> fleet = new ArrayList<>();

}
