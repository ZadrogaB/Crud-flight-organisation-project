package com.flight_project.practice_project.objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "Aerodrome")
public class Aerodrome {

    @Id
    @GeneratedValue
    @Column(name = "Id", nullable = false, unique = true)
    private Long id;

    @Column(name = "ICAO", unique = true)
    private String name;

    @Column(name = "City", nullable = false)
    private String city;

    @Column(name = "TORA", nullable = false)
    private Long RwyLength;

    @Column(name = "JetA" , nullable = false)
    private double fuelPrice;

}
