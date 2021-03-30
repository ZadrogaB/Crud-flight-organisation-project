package com.flight_project.practice_project.repository;

import com.flight_project.practice_project.objects.Company;
import org.springframework.data.repository.CrudRepository;
import java.util.*;

public interface CompanyRepository extends CrudRepository<Company, Long> {
    @Override
    List<Company> findAll();

    @Override
    Optional<Company> findById(final Long id);

    @Override
    Company save(final Company company);

    @Override
    void deleteById(final Long id);
}
