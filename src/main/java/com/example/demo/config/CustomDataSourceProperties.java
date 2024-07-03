package com.example.demo.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@ConfigurationProperties(prefix = "datasource")
public class CustomDataSourceProperties {    private String url;
    private String username;
    private String password;
    private final Map<String, Slave> slave = new HashMap<>();

    @Getter
    @Setter
    public static class Slave {
        private String name;
        private String url;
    }
}
