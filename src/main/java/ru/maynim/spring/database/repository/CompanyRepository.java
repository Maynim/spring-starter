package ru.maynim.spring.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.maynim.spring.database.entity.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

    // Optional, Entity, Future
    Optional<Company> findByName(String name);

    // Collection, Stream (batch, close)
    List<Company> findAllByNameContainingIgnoreCase(String fragment);
}
