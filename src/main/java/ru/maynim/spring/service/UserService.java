package ru.maynim.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.maynim.spring.database.entity.Company;
import ru.maynim.spring.database.repository.CrudRepository;
import ru.maynim.spring.database.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final CrudRepository<Integer, Company> companyRepository;
}
