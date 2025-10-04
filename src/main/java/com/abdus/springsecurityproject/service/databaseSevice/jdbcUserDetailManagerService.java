package com.abdus.springsecurityproject.service.databaseSevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
public class jdbcUserDetailManagerService {

    @Autowired
    private DataSource dataSource; // a object that represents a connection to a database.



    @Bean("jdbcUserDetailsService")
    public UserDetailsService userDetailsService() {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        UserDetails user1 = User.withUsername("user1")
                .password("password")
                .roles("USER")
                .build();
        UserDetails admin = User.withUsername("admin")
                .password("password")
                .roles("ADMIN")
                .build();

        if(!jdbcUserDetailsManager.userExists(user1.getUsername())) {
            jdbcUserDetailsManager.createUser(user1);
        }
        if(!jdbcUserDetailsManager.userExists(admin.getUsername())) {
            jdbcUserDetailsManager.createUser(admin);
        }

        return jdbcUserDetailsManager;
    }
}
