package com.flight_project.practice_project.controler;

import com.flight_project.practice_project.DbService.CompanyDbService;
import com.flight_project.practice_project.exceptions.CompanyNotExist;
import com.flight_project.practice_project.mapper.CompanyMapper;
import com.flight_project.practice_project.objects.Company;
import com.flight_project.practice_project.objects.dto.CompanyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/project/aeroplanes")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyDbService service;
    private final CompanyMapper mapper;

    @PostMapping(value = "createCompany", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createCompany (@RequestBody CompanyDto companyDto){
        service.saveCompanies(mapper.mapToCompany(companyDto));
    }

    @GetMapping(value = "getCompany")
    public CompanyDto getCompany(@RequestParam Long id) throws CompanyNotExist {
        return mapper.mapToCompanyDto(service.getCompany(id).orElseThrow(CompanyNotExist::new)
        );
    }

    @GetMapping(value = "getCompanies")
    public List<CompanyDto> getCompanies() {
        return mapper.mapToCompanyDtoList(service.getAllCompanies());
    }

    @PutMapping(value = "updateCompany")
    public CompanyDto updateCompany(@RequestBody CompanyDto companyDto){
        Company savedCompany = service.saveCompanies(mapper.mapToCompany(companyDto));
        return mapper.mapToCompanyDto(savedCompany);
    }

    @DeleteMapping(value = "deleteCompany")
    public CompanyDto deleteCompany(@RequestParam Long id) throws CompanyNotExist {
        CompanyDto companyDto = getCompany(id);
        service.deleteCompany(id);
        return companyDto;
    }
}