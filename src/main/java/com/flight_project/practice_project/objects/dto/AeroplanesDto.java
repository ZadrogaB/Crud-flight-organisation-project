package com.flight_project.practice_project.objects.dto;

import com.flight_project.practice_project.objects.Company;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;

@AllArgsConstructor
@Getter
public class AeroplanesDto {
    private Long id;
    private String type;
    private Long range;
    private Long fuelConsumption;
    private Long capacityOfPassengers;
    private Long runwayLength;
    private Company owner;
}
