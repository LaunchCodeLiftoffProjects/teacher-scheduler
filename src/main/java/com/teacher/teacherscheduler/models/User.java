package com.teacher.teacherscheduler.models;

import org.hibernate.validator.constraints.Email;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by LaunchCode
 */
@Entity
public class User {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min= 5, max= 15)
    private String username;

    @Email(message = "Invalid email address")
    private String email;

    @NotNull
    @Size(min=5, message = "Password must be at least 5 characters long")
    private String password;

    @ManyToOne
    private Type type;

    public User(String username, String email, String password, Type type) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.type = type;
    }

    public User() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

}