package com.artapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="Login")
public class Login {

    @Id
    @NotBlank(message = "EmailId is required")
    private String emailId;

    @Column
    @NotBlank(message = "Password is required")
    private String password;

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Login() {}

    @Override
    public String toString() {
        return "Login [emailId=" + emailId + ", password=" + password + "]";
    }
}
