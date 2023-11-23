package com.dennis.onlineshopinterview.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.dennis.onlineshopinterview.model.Customer;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JWTService {

    @Value("${jwt.algorithm.key}")
    private String algorithmKey;
    @Value("${jwt.issuer}")
    private String issuer;
    @Value("${jwt.expiryInSeconds}")
    private String expiryInSeconds;
    private Algorithm algorithm;
    private static final String EMAIL_KEY= "EMAIL";

    @PostConstruct
    public void postConstruct(){
        algorithm = Algorithm.HMAC256(algorithmKey);
    }

    public String generateJWT(Customer user){
        return JWT.create()
                .withClaim(EMAIL_KEY, user.email)
                .withExpiresAt(new Date(System.currentTimeMillis() + (1000 + expiryInSeconds)))
                .withIssuer(issuer)
                .sign(algorithm);
    }

}
