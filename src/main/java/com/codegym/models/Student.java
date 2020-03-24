package com.codegym.models;

// Entity .. POJO (Plain Old Java Objects)

public class Student {

    private String name; // properties, setter, getter .. NO LOGIC CODES

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
