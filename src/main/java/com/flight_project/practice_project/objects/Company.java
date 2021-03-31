package com.flight_project.practice_project.objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Company {

    @Id
    @GeneratedValue
    @Column(name = "Id", nullable = false, unique = true)
    private Long id;

    @Column(name = "Name", unique = true, nullable = false)
    private String companyName;

    @Column(name = "Station", nullable = false)
    private String station;

    @JsonBackReference
    @OneToMany (
            targetEntity = Aeroplanes.class,
            mappedBy = "owner",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Aeroplanes> fleet;

    /*public void addAeroplane(Aeroplanes aeroplane) {
        fleet.add(aeroplane);
    }*/



}
