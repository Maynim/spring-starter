package ru.maynim.spring;

import ru.maynim.spring.database.pool.ConnectionPool;
import ru.maynim.spring.database.repository.CompanyRepository;
import ru.maynim.spring.database.repository.UserRepository;
import ru.maynim.spring.ioc.Container;
import ru.maynim.spring.service.UserService;

public class ApplicationRunner {

    public static void main(String[] args) {
        Container container = new Container();
//        ConnectionPool connectionPool = new ConnectionPool();
//        UserRepository userRepository = new UserRepository(connectionPool);
//        CompanyRepository companyRepository = new CompanyRepository(connectionPool);
//        UserService userService = new UserService(userRepository, companyRepository);

        ConnectionPool connectionPool = container.get(ConnectionPool.class);
        UserRepository userRepository = container.get(UserRepository.class);
        CompanyRepository companyRepository = container.get(CompanyRepository.class);
        UserService userService = container.get(UserService.class);
        // TODO: 11.08.2022 userService
    }
}
