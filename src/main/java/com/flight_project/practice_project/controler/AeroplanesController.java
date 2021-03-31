package com.flight_project.practice_project.controler;

import com.flight_project.practice_project.DbService.AeroplanesDbService;
import com.flight_project.practice_project.DbService.CompanyDbService;
import com.flight_project.practice_project.exceptions.AeroplaneNotExist;
import com.flight_project.practice_project.exceptions.CompanyNotExist;
import com.flight_project.practice_project.mapper.AeroplanesMapper;
import com.flight_project.practice_project.objects.Aeroplanes;
import com.flight_project.practice_project.objects.Company;
import com.flight_project.practice_project.objects.dto.AeroplanesDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.*;

//@CrossOrigin(origins = "*")   potrzebne będzie do frontu!
@RestController
@RequestMapping("/project/aeroplanes")
@RequiredArgsConstructor
public class AeroplanesController {

    private final AeroplanesDbService service;
    private final CompanyDbService companyDbService;
    private final AeroplanesMapper mapper;

    @PostMapping(value = "createAeroplane", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createAeroplane(@RequestBody AeroplanesDto aeroplanesDto) {
        Aeroplanes aeroplane = mapper.mapToAeroplanes(aeroplanesDto);
        service.saveAeroplanes(aeroplane);
    }

    @GetMapping(value = "getAeroplane")
    public AeroplanesDto getAeroplane(@RequestParam Long id) throws AeroplaneNotExist {
        return mapper.mapToAeroplanesDto(
                service.getAeroplane(id).orElseThrow(AeroplaneNotExist::new)
        );
    }

    @GetMapping(value = "getAeroplanes")
    public List<AeroplanesDto> getAeroplanes() {
        return mapper.mapToAeroplanesDtoList(service.getAllAeroplanes());
    }

    @PutMapping(value = "updateAeroplane")
    public AeroplanesDto updateAeroplane(@RequestBody AeroplanesDto aeroplanesDto) {
        Aeroplanes savedAeroplane = service.saveAeroplanes(mapper.mapToAeroplanes(aeroplanesDto));
        return mapper.mapToAeroplanesDto(savedAeroplane);
    }

    @DeleteMapping(value = "deleteAeroplane")
    public AeroplanesDto deleteAeroplane(@RequestParam Long id) throws AeroplaneNotExist {
        AeroplanesDto aeroplaneDto = getAeroplane(id);
        service.deleteAeroplane(id);
        return aeroplaneDto;
    }

    @PutMapping(value = "addOwner")
    public void addOwner(@RequestParam Long aeroplaneId, Long companyId) throws AeroplaneNotExist, CompanyNotExist {
        Aeroplanes aeroplane = service.getAeroplane(aeroplaneId).orElseThrow(AeroplaneNotExist::new);
        Company company = companyDbService.getCompany(companyId).orElseThrow(CompanyNotExist::new);
        aeroplane.setOwner(company);
        updateAeroplane(mapper.mapToAeroplanesDto(aeroplane));
    }


}