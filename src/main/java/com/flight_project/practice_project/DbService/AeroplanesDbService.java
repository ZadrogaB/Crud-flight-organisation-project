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

    public Optional<Aeroplanes> getAeroplane (final Long id) {
        return repository.findById(id);
    }

    public void deleteAeroplane (final Long id) {
        repository.deleteById(id) ;
    }

   /* public Aeroplanes addOwner (final Long aeroplaneId, final Long companyId ){

    }*/
}
