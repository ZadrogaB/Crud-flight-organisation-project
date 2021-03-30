package com.flight_project.practice_project.repository;

import com.flight_project.practice_project.objects.Aerodrome;
import org.springframework.data.repository.CrudRepository;

public interface AerodromeRepository extends CrudRepository<Aerodrome, Long> {
}
