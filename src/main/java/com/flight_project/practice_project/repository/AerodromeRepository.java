package com.flight_project.practice_project.repository;

import com.flight_project.practice_project.objects.Aerodrome;
import org.springframework.data.repository.CrudRepository;
import java.util.*;

public interface AerodromeRepository extends CrudRepository<Aerodrome, Long> {

    @Override
    List<Aerodrome> findAll();

    @Override
    Optional<Aerodrome> findById(final Long id);

    @Override
    Aerodrome save(final Aerodrome aerodrome);

    @Override
    void deleteById(final Long id);
}
