package com.dennis.onlineshopinterview.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "Users")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id", nullable = false)
    public UUID id;
    @Column(name = "EmailAddress", nullable = false, unique = true, length = 320)
    public String email;
    @Column(name = "FirstName", nullable = false, length = 255)
    public String firstName;
    @Column(name = "LastName", nullable = false, length = 255)
    public String lastName;
    @Column(name = "PasswordHash", nullable = false, length = 1000)
    public String passwordHash;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}
