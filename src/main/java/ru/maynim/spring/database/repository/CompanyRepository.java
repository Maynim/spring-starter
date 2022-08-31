package ru.maynim.spring.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.maynim.spring.database.entity.Company;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

    // Optional, Entity, Future
    // @Query(name = "Company.findByName")
    @Query("SELECT c FROM Company c JOIN FETCH c.locales cl WHERE c.name = :name")
    Optional<Company> findByName(@Param("name") String name);

    // Collection, Stream (batch, close)
    List<Company> findAllByNameContainingIgnoreCase(String fragment);
}
