package com.dennis.onlineshopinterview.api.controller;

import com.dennis.onlineshopinterview.api.model.LoginRequest;
import com.dennis.onlineshopinterview.api.model.RegistrationRequest;
import com.dennis.onlineshopinterview.exception.UserExistsException;
import com.dennis.onlineshopinterview.model.Customer;
import com.dennis.onlineshopinterview.repository.UserRepository;
import com.dennis.onlineshopinterview.service.JWTService;
import com.dennis.onlineshopinterview.service.UserService;
import com.dennis.onlineshopinterview.shared.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private UserService userService;
    @Autowired
    private JWTService jwtService;
    @Autowired
    private UserRepository userRepository;
    @PostMapping("/register")
    public ResponseEntity registerUser(@Valid @RequestBody RegistrationRequest registrationRequestBody) {
        try {
            userService.registerUser(registrationRequestBody);
            return ResponseEntity.ok().build();
        } catch (UserExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> loginUser(@Valid @RequestBody LoginRequest loginRequest) {
        String jwt = userService.loginUser(loginRequest);
        if(jwt == null){
            return new ResponseEntity<>(new ApiResponse("Invalid credentials", false),
                    HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(new ApiResponse(jwt, true),
                    HttpStatus.OK);
        }
    }

    @GetMapping("/test")
    public Customer get(@AuthenticationPrincipal Customer customer){
        return customer;
    }
}