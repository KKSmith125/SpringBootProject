package com.kaylee.application.SpringApplication.config;

import java.beans.BeanProperty;

@Configuration
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
