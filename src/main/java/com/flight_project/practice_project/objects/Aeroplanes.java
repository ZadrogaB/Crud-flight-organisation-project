package com.flight_project.practice_project.objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter()
@Entity(name = "Aeroplanes")
public class Aeroplanes {

    @Id
    @GeneratedValue
    @Column(name = "Id", nullable = false, unique = true)
    private Long id;

    @Column(name = "AeroplaneType", nullable = false)
    private String type;

    @Column(name = "PossibleDistance", nullable = false)
    private Long range;

    @Column(name = "FuelUsage", nullable = false)
    private Long fuelConsumption;

    @Column(name = "Seats", nullable = false)
    private Long capacityOfPassengers;

    @Column(name = "Runway", nullable = false)
    private Long runwayLength;



    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "AeroplaneOwner")
    private Company owner;

    public void setOwner(Company company){
        owner = company;
    }
}
