package com.abdus.springsecurityproject.controller;


import jakarta.annotation.PreDestroy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HealthCheck {
    @GetMapping("/public")
    public  ResponseEntity healthCheck() {
        return  new  ResponseEntity<>("hello World", HttpStatus.OK);
    }

    @GetMapping("/user")
    public  ResponseEntity user() {
        return  new  ResponseEntity<>("hello User", HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public  ResponseEntity admin() {
        return  new  ResponseEntity<>("hello admin", HttpStatus.OK);
    }
}
