package ru.maynim.spring.config;

import javax.annotation.PostConstruct;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import ru.maynim.spring.config.condition.JpaCondition;

@Conditional(JpaCondition.class)
@Configuration
public class JpaConfiguration {

    @PostConstruct
    void init() {
        System.out.println("JPA Enable");
    }
}
