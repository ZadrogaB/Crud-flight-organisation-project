package com.flight_project.practice_project.DbService;

import com.flight_project.practice_project.objects.Aerodrome;
import com.flight_project.practice_project.repository.AerodromeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@RequiredArgsConstructor
public class AerodromeDbService {

    private final AerodromeRepository repository;

    public Aerodrome saveAerodrome(final Aerodrome aerodrome){
        return repository.save(aerodrome);
    }

    public Optional<Aerodrome> getAerodrome(final Long id) {
        return repository.findById(id);
    }

    public List<Aerodrome> getAerodromes(){
        return repository.findAll();
    }

    public void deleteAerodrome(final Long id){
        repository.deleteById(id);
    }
}
