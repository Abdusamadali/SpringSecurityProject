package com.abdus.springsecurityproject.service.databaseSevice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;



public class InMemoryUserDetailsService {

    public UserDetails user1,admin;


    public UserDetailsService userDetailsService() {

       this.user1 = User.withUsername("user1")
                .password("{noop}password")
                .roles("USER")
                .build();
         this.admin = User.withUsername("Admin")
                .password("{noop}password")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user1, admin);
    }
}
