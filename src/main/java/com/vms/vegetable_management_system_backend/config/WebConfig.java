package com.vms.vegetable_management_system_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:5173", "http://localhost:3000") // Allow multiple origins
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Add OPTIONS for preflight requests
                        .allowedHeaders("*") // Allow all headers
                        .allowCredentials(true); // Allow cookies or authentication headers
            }
        };
    }
}
