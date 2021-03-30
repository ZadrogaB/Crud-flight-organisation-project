package com.flight_project.practice_project.repository;

import com.flight_project.practice_project.objects.Company;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<Company, Long> {
}
