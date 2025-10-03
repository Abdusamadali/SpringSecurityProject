package com.abdus.springsecurityproject.filters;


import jakarta.servlet.FilterChain;
import lombok.Builder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityConfigFunction(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(req->req.anyRequest().authenticated());
        http.httpBasic(withDefaults());
        return http.build();
    }
}
