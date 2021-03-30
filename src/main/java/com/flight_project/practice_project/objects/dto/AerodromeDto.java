package com.flight_project.practice_project.objects.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AerodromeDto {
    private Long id;
    private String name;
    private String city;
    private Long RwyLength;
    private double fuelPrice;

}
