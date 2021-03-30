package com.flight_project.practice_project.controler;

import com.flight_project.practice_project.DbService.AeroplanesDbService;
import com.flight_project.practice_project.mapper.AeroplanesMapper;
import com.flight_project.practice_project.objects.Aeroplanes;
import com.flight_project.practice_project.objects.dto.AeroplanesDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/project/aeroplanes")
@RequiredArgsConstructor
public class AeroplanesController {

    private final AeroplanesDbService service;
    private final AeroplanesMapper mapper;

    @PostMapping(value = "createAeroplane", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createAeroplane(@RequestBody AeroplanesDto aeroplanesDto) {
        Aeroplanes aeroplane = mapper.mapToAeroplanes(aeroplanesDto);
        service.saveAeroplanes(aeroplane);
    }
}
