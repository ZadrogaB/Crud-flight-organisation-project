package com.flight_project.practice_project.controler;

import com.flight_project.practice_project.DbService.AerodromeDbService;
import com.flight_project.practice_project.exceptions.AerodromeNotExist;
import com.flight_project.practice_project.mapper.AerodromeMapper;
import com.flight_project.practice_project.objects.Aerodrome;
import com.flight_project.practice_project.objects.dto.AerodromeDto;
import java.util.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/project/aeroplanes")
@RequiredArgsConstructor
public class AerodromeController {

    private final AerodromeDbService service;
    private final AerodromeMapper mapper;

    @PostMapping(value = "createAerodrome", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createAerodrome(@RequestBody AerodromeDto aerodromeDto){
        Aerodrome aerodrome = mapper.mapToAerodrome(aerodromeDto);
        service.saveAerodrome(aerodrome);
    }

    @GetMapping(value = "getAerodrome")
    public AerodromeDto getAerodrome(@RequestParam Long id) throws AerodromeNotExist {
        return mapper.mapToAerodromeDto(
                service.getAerodrome(id).orElseThrow(AerodromeNotExist::new)
        );
    }

    @GetMapping(value = "getAerodromes")
    public List<AerodromeDto> getAerodromes(){
        return mapper.mapToListAerodromeDto(service.getAerodromes());
    }

    @PutMapping(value = "updateAerodrome")
    public AerodromeDto updateAerodrome(@RequestBody AerodromeDto aerodromeDto){
        Aerodrome savedAerodrome = service.saveAerodrome(mapper.mapToAerodrome(aerodromeDto));
        return mapper.mapToAerodromeDto(savedAerodrome);
    }

    @DeleteMapping(value = "deleteAerodrome")
    public AerodromeDto deleteAerodrome(@RequestParam Long id) throws AerodromeNotExist {
        AerodromeDto aerodromeDto = getAerodrome(id);
        service.deleteAerodrome(id);
        return aerodromeDto;
    }
}
