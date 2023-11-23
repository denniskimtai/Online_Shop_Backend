package com.dennis.onlineshopinterview.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class EncryptionService {
    @Value("${encryption.salt.rounds}")
    private int saltRounds;

    private String salt;

    @PostConstruct
    private void postConstruct(){
        salt = BCrypt.gensalt();
    }

    public String encryptPassword(String password){
        return BCrypt.hashpw(password, salt);
    }

    public boolean verifyPassword(String password, String passwordHash){
        return BCrypt.checkpw(password, passwordHash);
    }
}
