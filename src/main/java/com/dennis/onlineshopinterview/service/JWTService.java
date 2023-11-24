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
    private static final String USER_ID= "USER_ID";

    @PostConstruct
    public void postConstruct(){
        algorithm = Algorithm.HMAC256(algorithmKey);
    }

    public String generateJWT(Customer user){
        return JWT.create()
                .withClaim(USER_ID, String.valueOf(user.getId()))
                .withExpiresAt(new Date(System.currentTimeMillis() + Long.parseLong(expiryInSeconds) * 1000))
                .withIssuer(issuer)
                .sign(algorithm);
    }

    public String getUserId(String token){
        return JWT.decode(token).getClaim(USER_ID).asString();
    }

}
