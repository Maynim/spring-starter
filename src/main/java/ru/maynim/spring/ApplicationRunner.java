package ru.maynim.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.maynim.spring.database.pool.ConnectionPool;
import ru.maynim.spring.database.repository.CompanyRepository;
import ru.maynim.spring.database.repository.UserRepository;
import ru.maynim.spring.ioc.Container;
import ru.maynim.spring.service.UserService;

public class ApplicationRunner {

    public static void main(String[] args) {
        CompanyRepository companyRepository;
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml")) {
            ConnectionPool pool2 = context.getBean("p1", ConnectionPool.class);
            System.out.println(pool2);
            companyRepository = context.getBean("companyRepository", CompanyRepository.class);
            System.out.println(companyRepository);
        }
    }
}
