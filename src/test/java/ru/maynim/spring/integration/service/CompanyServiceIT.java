package ru.maynim.spring.integration.service;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import ru.maynim.spring.config.DatabaseProperties;
import ru.maynim.spring.dto.CompanyReadDto;
import ru.maynim.spring.integration.annotation.IT;
import ru.maynim.spring.service.CompanyService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// @ExtendWith(SpringExtension.class)
// @ContextConfiguration(
//        classes = ApplicationRunner.class,
//        initializers = ConfigDataApplicationContextInitializer.class
// )
@IT
@RequiredArgsConstructor
public class CompanyServiceIT {

    private static final Integer COMPANY_ID = 1;

    private final CompanyService companyService;
    private final DatabaseProperties databaseProperties;

    @Test
    void findById() {
        Optional<CompanyReadDto> actualResult = companyService.findById(COMPANY_ID);

        assertTrue(actualResult.isPresent());

        CompanyReadDto expectedResult = new CompanyReadDto(COMPANY_ID);
        actualResult.ifPresent(actual -> assertEquals(expectedResult, actual));
    }
}
