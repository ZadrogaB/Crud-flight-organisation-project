package com.flight_project.practice_project.DbService;

import com.flight_project.practice_project.objects.Aeroplanes;
import com.flight_project.practice_project.repository.AeroplanesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@RequiredArgsConstructor
public class AeroplanesDbService {

    private final AeroplanesRepository repository;

    public List<Aeroplanes> getAllAeroplanes() {
        return repository.findAll();
    }

    public Aeroplanes saveAeroplanes(final Aeroplanes aeroplane) {
        return repository.save(aeroplane);
    }

    public Optional<Aeroplanes> getAeroplane (final Aeroplanes aeroplane) {
        return repository.findById(aeroplane.getId());
    }

    public void deleteAeroplane (final Aeroplanes aeroplane) {
        repository.deleteById(aeroplane.getId()) ;
    }
}
