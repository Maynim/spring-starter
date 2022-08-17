package ru.maynim.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ConfigurableApplicationContext;
import ru.maynim.spring.config.DatabaseProperties;

@SpringBootApplication
@ConfigurationPropertiesScan
public class ApplicationRunner {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ApplicationRunner.class, args);
        System.out.println(run.getBeanDefinitionCount());
        System.out.println(run.getBean("pool1"));
        System.out.println(run.getBean(DatabaseProperties.class));
    }
}
