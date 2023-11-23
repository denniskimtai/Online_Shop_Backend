package com.dennis.onlineshopinterview.api.model;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.*;

public class Registration {
    @NotNull
    @NotBlank
    @Email
    @Size(max = 320)
    private String emailAddress;
    @NotNull
    @NotBlank
    @Size(min = 2, max = 255)
    private String firstName;
    @NotNull
    @NotBlank
    @Size(min = 2, max = 255)
    private String lastName;
    @NotNull
    @NotBlank
    @Size(min = 6)
    private String password;

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
