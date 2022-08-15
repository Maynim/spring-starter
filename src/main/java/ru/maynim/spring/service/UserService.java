package ru.maynim.spring.service;

import org.springframework.stereotype.Service;
import ru.maynim.spring.database.entity.Company;
import ru.maynim.spring.database.repository.CrudRepository;
import ru.maynim.spring.database.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final CrudRepository<Integer, Company> companyRepository;

    public UserService(
            UserRepository userRepository, CrudRepository<Integer, Company> companyRepository) {
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
    }
}
