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
}
