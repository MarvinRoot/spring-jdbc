package com.spring.jdbc.hoxtify.controller;

import com.spring.jdbc.hoxtify.model.User;
import com.spring.jdbc.hoxtify.service.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(@RequestBody User user) {
        try {
            String token = authenticationService.validateUser(user);
            return new ResponseEntity<>(token, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Authentication Failed!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
