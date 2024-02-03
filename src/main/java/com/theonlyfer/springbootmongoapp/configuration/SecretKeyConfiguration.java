package com.theonlyfer.springbootmongoapp.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "spring.jwt")
public class SecretKeyConfiguration {

    private String secretKey;
}