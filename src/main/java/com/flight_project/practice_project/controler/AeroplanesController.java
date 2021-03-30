package com.flight_project.practice_project.controler;

import com.flight_project.practice_project.DbService.AeroplanesDbService;
import com.flight_project.practice_project.mapper.AeroplanesMapper;
import com.flight_project.practice_project.objects.Aeroplanes;
import com.flight_project.practice_project.objects.dto.AeroplanesDto;
import com.flight_project.practice_project.objects.exceptions.AeroplaneException;
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
    private final AeroplanesMapper mapper;

    @PostMapping(value = "createAeroplane", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createAeroplane(@RequestBody AeroplanesDto aeroplanesDto) {
        Aeroplanes aeroplane = mapper.mapToAeroplanes(aeroplanesDto);
        service.saveAeroplanes(aeroplane);
    }

    @GetMapping(value = "getAeroplane")
    public AeroplanesDto getAeroplane(@RequestParam Long id) throws AeroplaneException {
        return mapper.mapToAeroplanesDto(
                service.getAeroplane(id).orElseThrow(AeroplaneException::new)
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
    public AeroplanesDto deleteAeroplane(@RequestParam Long id) throws AeroplaneException {
        AeroplanesDto aeroplaneDto = getAeroplane(id);
        service.deleteAeroplane(id);
        return aeroplaneDto;
    }


}
