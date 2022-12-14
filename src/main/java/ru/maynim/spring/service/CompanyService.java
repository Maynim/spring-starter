package ru.maynim.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.maynim.spring.database.repository.CompanyRepository;
import ru.maynim.spring.dto.CompanyReadDto;
import ru.maynim.spring.listener.entity.AccessType;
import ru.maynim.spring.listener.entity.EntityEvent;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final UserService userService;
    private final ApplicationEventPublisher eventPublisher;

    @Transactional
    public Optional<CompanyReadDto> findById(Integer id) {
        return companyRepository
                .findById(id)
                .map(
                        entity -> {
                            eventPublisher.publishEvent(new EntityEvent(entity, AccessType.READ));
                            return new CompanyReadDto(entity.getId());
                        });
    }
}
