package ru.maynim.spring.config;

import java.util.List;
import java.util.Map;
import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Value
@ConstructorBinding
@ConfigurationProperties(prefix = "db")
public class DatabaseProperties {
    String username;
    String password;
    String driver;
    String url;
    String hosts;
    PoolProperties pool;
    List<PoolProperties> pools;
    Map<String, Object> properties;

    @Value
    public static class PoolProperties {
        Integer size;
        Integer timeout;
    }
}
