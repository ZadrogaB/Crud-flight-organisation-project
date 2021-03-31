package com.flight_project.practice_project.repository;

import com.flight_project.practice_project.objects.Aeroplanes;
import org.springframework.data.repository.CrudRepository;
import java.util.*;

public interface AeroplanesRepository extends CrudRepository<Aeroplanes, Long> {
    @Override
    List<Aeroplanes> findAll();

    @Override
    Optional<Aeroplanes> findById (final Long id);

    @Override
    Aeroplanes save (final Aeroplanes aeroplanes);

    @Override
    void deleteById(final Long id);


}
