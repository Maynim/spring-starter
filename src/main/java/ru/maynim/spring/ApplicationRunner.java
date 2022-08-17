package ru.maynim.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ApplicationRunner {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ApplicationRunner.class, args);
        System.out.println(run.getBeanDefinitionCount());
    }
}
