package com.graduation.examples.design.patterns.builder;

import org.omg.CORBA.DynAnyPackage.InvalidValue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Consumer;

public class PersonBuilder {
    private String firstname;
    private String lastname;

    private Date birthdate;
    private Nationality nationality = Nationality.Ro;


    public PersonBuilder with(Consumer<PersonBuilder> builderFunction) {
        builderFunction.accept(this);
        return this;
    }

    public Person createPerson() {
        return new Person(firstname, lastname, birthdate, nationality);
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setBirthdate(String birthdate) throws InvalidValue, ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
        Date d = sdf.parse("01-01-1950");
        Date date = sdf.parse(birthdate);
        if (date.after(d))
            this.birthdate = date;
        else throw new InvalidValue("you're too old!!");
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }
}
