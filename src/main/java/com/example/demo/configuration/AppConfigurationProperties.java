package com.example.demo.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

class ApplicationConfig {
    String jwtSecret;
    Integer jwtExpirationMs;
}

@ConfigurationProperties(prefix = "bezkoder")
@Getter
@Setter
public class AppConfigurationProperties {
    ApplicationConfig applicationConfig;
}
