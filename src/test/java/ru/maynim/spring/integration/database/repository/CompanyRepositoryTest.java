package ru.maynim.spring.integration.database.repository;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.maynim.spring.database.entity.Company;
import ru.maynim.spring.database.repository.CompanyRepository;
import ru.maynim.spring.integration.IntegrationTestBase;

import javax.persistence.EntityManager;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RequiredArgsConstructor
class CompanyRepositoryTest extends IntegrationTestBase {

    public static final Integer GOOGLE_ID = 1;
    private final EntityManager entityManager;
    private final CompanyRepository companyRepository;

    @Test
    void checkFindByQueries() {
        companyRepository.findByName("google");
        companyRepository.findAllByNameContainingIgnoreCase("a");
    }

    @Test
    @Disabled
    void delete() {
        Optional<Company> optionalCompany = companyRepository.findById(GOOGLE_ID);
        assertTrue(optionalCompany.isPresent());
        optionalCompany.ifPresent(companyRepository::delete);
        entityManager.flush();
        assertTrue(companyRepository.findById(GOOGLE_ID).isEmpty());
    }

    @Test
    void findById() {
        Optional<Company> company = companyRepository.findByName("Google");

        assertTrue(company.isPresent());
    }

    @Test
    void save() {
        Company company =
                Company.builder()
                        .name("Apple")
                        .locales(
                                Map.of(
                                        "ru", "Apple описание",
                                        "en", "Apple description"))
                        .build();
        entityManager.persist(company);
        assertNotNull(company.getId());
    }
}
