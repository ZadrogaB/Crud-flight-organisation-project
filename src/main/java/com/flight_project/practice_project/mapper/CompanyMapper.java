package com.flight_project.practice_project.mapper;

import com.flight_project.practice_project.objects.Company;
import com.flight_project.practice_project.objects.dto.AeroplanesDto;
import com.flight_project.practice_project.objects.dto.CompanyDto;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CompanyMapper {

    public CompanyDto mapToCompanyDto(final Company company){
        return new CompanyDto(company.getId(),
                company.getCompanyName(),
                company.getStation(),
                company.getFleet()
        );
    }

    public Company mapToCompany(final CompanyDto companyDto){
        return new Company(companyDto.getId(),
                companyDto.getCompanyName(),
                companyDto.getStation(),
                companyDto.getFleet());
    }

    public List<CompanyDto> mapToCompanyDtoList(final List<Company> company){
        return company.stream()
                .map(n-> mapToCompanyDto(n))
                .collect(Collectors.toList());
    }
}
