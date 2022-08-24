package ru.maynim.spring.config;

import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import ru.maynim.spring.config.condition.JpaCondition;

@Slf4j
@Conditional(JpaCondition.class)
@Configuration
public class JpaConfiguration {

    //    @Bean
    //    @ConfigurationProperties(prefix = "db")
    //    public DatabaseProperties databaseProperties() {
    //        return new DatabaseProperties();
    //    }

    @PostConstruct
    void init() {
        log.info("JPA Enable");
    }
}
