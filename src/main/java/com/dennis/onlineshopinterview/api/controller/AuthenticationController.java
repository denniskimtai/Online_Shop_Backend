package com.dennis.onlineshopinterview.api.controller;

import com.dennis.onlineshopinterview.api.model.Registration;
import com.dennis.onlineshopinterview.exception.UserExistsException;
import com.dennis.onlineshopinterview.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private UserService userService;

    @PostMapping(name = "/register")
    public ResponseEntity registerUser(@Valid @RequestBody Registration registrationBody) {
        try {
            userService.registerUser(registrationBody);
            return ResponseEntity.ok().build();
        } catch (UserExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
