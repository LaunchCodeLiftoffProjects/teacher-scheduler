package com.teacher.teacherscheduler.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Type {

    @Id
    @GeneratedValue
    private int id;


    @NotNull
    @Size(min = 3, max = 15, message = "Please keep it above 3 and under 15 characters.")
    private String name;

    @OneToMany
    @JoinColumn(name = "type_id")
    private List<User> users = new ArrayList<>();

    public Type() { }

    public Type(String name) {
        this.name = name; }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUser() {
        return users;
    }
}
