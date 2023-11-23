package com.dennis.onlineshopinterview.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    public UUID id;
    @Nonnull
    @Column(name = "EmailAddress")
    public String email;
    @Nonnull
    @Column(name = "FirstName")
    public String firstName;
    @Nonnull
    @Column(name = "LastName")
    public String lastName;
    @Nonnull
    @Column(name = "Password")
    public String passwordHash;
}
