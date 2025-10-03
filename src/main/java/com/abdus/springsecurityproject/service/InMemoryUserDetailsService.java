package com.abdus.springsecurityproject.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class InMemoryUserDetailsService {
    @Bean
    public UserDetailsService userDetailsService() {

        UserDetails user1 = User.withUsername("user1")
                .password("{noop}password")
                .roles("USER")
                .build();
        UserDetails admin = User.withUsername("Admin")
                .password("{noop}password")
                .roles("ADMIN")
                .build();


        return new InMemoryUserDetailsManager(user1, admin);
    }
}
