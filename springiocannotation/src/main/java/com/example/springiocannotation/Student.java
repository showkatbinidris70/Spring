package com.example.springiocannotation;

public class Student {
    private Stirng name;

    public Stirng getName() {
        return name;
    }

    public void setName(Stirng name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + "]";
    }
}
