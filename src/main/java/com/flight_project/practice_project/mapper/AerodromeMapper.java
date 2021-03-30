package com.flight_project.practice_project.mapper;

import com.flight_project.practice_project.objects.Aerodrome;
import com.flight_project.practice_project.objects.dto.AerodromeDto;
import com.flight_project.practice_project.objects.dto.AeroplanesDto;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class AerodromeMapper {

    public AerodromeDto mapToAerodromeDto(final Aerodrome aerodrome){
        return new AerodromeDto(aerodrome.getId(),
                aerodrome.getName(),
                aerodrome.getCity(),
                aerodrome.getRwyLength(),
                aerodrome.getFuelPrice()
        );
    }

    public Aerodrome mapToAerodrome (final AerodromeDto aerodromeDto) {
        return new Aerodrome(aerodromeDto.getId(),
                aerodromeDto.getName(),
                aerodromeDto.getCity(),
                aerodromeDto.getRwyLength(),
                aerodromeDto.getFuelPrice()
        );
    }

    public List<AerodromeDto> mapToListAerodromeDto(List<Aerodrome> aerodromeList){
        return aerodromeList.stream()
                .map(this::mapToAerodromeDto)
                .collect(Collectors.toList());
    }
}
