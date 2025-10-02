package com.abdus.springsecurityproject.controller;

import jdk.jshell.Snippet;
import org.apache.coyote.Response;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.OutputKeys;


@RestController
public class HealthCheck {
    @GetMapping("/health-check")
    public  ResponseEntity healthCheck() {
        return  new  ResponseEntity<>("hello World", HttpStatus.OK);
    }
}
