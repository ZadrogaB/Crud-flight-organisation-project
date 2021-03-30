package com.flight_project.practice_project.DbService;

import com.flight_project.practice_project.objects.Aeroplanes;
import com.flight_project.practice_project.objects.Company;
import com.flight_project.practice_project.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyDbService {

    private final CompanyRepository repository;

    public List<Company> getAllCompanies() {
        return repository.findAll();
    }

    public Company saveCompanies(final Company company) {
        return repository.save(company);
    }

    public Optional<Company> getCompany (final Long id) {
        return repository.findById(id);
    }

    public void deleteCompany (final Long id) {
        repository.deleteById(id) ;
    }
}
