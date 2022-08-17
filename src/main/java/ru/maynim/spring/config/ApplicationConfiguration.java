package ru.maynim.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Component;
import ru.maynim.spring.database.pool.ConnectionPool;
import ru.maynim.spring.database.repository.CrudRepository;
import ru.maynim.spring.database.repository.UserRepository;
import ru.maynim.web.config.WebConfiguration;

@Import(WebConfiguration.class)
@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(
        basePackages = "ru.maynim.spring",
        useDefaultFilters = false,
        includeFilters = {
            @Filter(type = FilterType.ANNOTATION, value = Component.class),
            @Filter(type = FilterType.ASSIGNABLE_TYPE, value = CrudRepository.class),
            @Filter(type = FilterType.REGEX, pattern = "ru\\..+Repository")
        })
public class ApplicationConfiguration {

    @Bean
    public ConnectionPool pool2(@Value("${db.username}") String username) {
        return new ConnectionPool(username, 20);
    }

    @Bean
    public ConnectionPool pool3() {
        return new ConnectionPool("test-pool", 25);
    }

    @Bean
    @Profile("prod|web")
    public UserRepository userRepository2(ConnectionPool pool2) {
        return new UserRepository(pool2);
    }

    @Bean
    public UserRepository userRepository3() {
        return new UserRepository(pool3());
    }
}
