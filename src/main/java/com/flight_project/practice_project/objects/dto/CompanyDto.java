package com.flight_project.practice_project.objects.dto;

import com.flight_project.practice_project.objects.Aeroplanes;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public class CompanyDto {
    private Long id;
    private String companyName;
    private String station;
    private List<Aeroplanes> fleet = new ArrayList<>();
}
