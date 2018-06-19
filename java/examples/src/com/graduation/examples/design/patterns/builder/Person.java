package com.graduation.examples.design.patterns.builder;

import java.util.Date;

public class Person {
    private String firstname;
    private String lastname;

    private Date birthdate;
    private Nationality nationality;

    Person(String firstname,
           String lastname,
           Date birthdate,
           Nationality nationality) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthdate=" + birthdate +
                ", nationality=" + nationality +
                '}';
    }
}
