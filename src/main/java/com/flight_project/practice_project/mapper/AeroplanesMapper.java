package com.flight_project.practice_project.mapper;

import com.flight_project.practice_project.objects.Aeroplanes;
import com.flight_project.practice_project.objects.dto.AeroplanesDto;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AeroplanesMapper {

    public AeroplanesDto mapToAeroplanesDto (final Aeroplanes aeroplane){
        return new AeroplanesDto (aeroplane.getId(),
                aeroplane.getType(),
                aeroplane.getRange(),
                aeroplane.getFuelConsumption(),
                aeroplane.getCapacityOfPassengers(),
                aeroplane.getRunwayLength(),
                aeroplane.getOwner());
    }

    public Aeroplanes mapToAeroplanes (final AeroplanesDto aeroplanesDto){
        return new Aeroplanes(aeroplanesDto.getId(),
                aeroplanesDto.getType(),
                aeroplanesDto.getRange(),
                aeroplanesDto.getFuelConsumption(),
                aeroplanesDto.getCapacityOfPassengers(),
                aeroplanesDto.getRunwayLength(),
                aeroplanesDto.getOwner());
    }

    public List<AeroplanesDto> mapToAeroplanesDtoList(final List<Aeroplanes> aeroplanesList) {
        return aeroplanesList.stream()
                .map(this::mapToAeroplanesDto)
                .collect(Collectors.toList());
    }
}
