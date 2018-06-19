package com.graduation.examples.design.patterns;

import com.graduation.examples.design.patterns.builder.Nationality;
import com.graduation.examples.design.patterns.builder.Person;
import com.graduation.examples.design.patterns.builder.PersonBuilder;
import org.omg.CORBA.DynAnyPackage.InvalidValue;

import java.text.ParseException;

public class Main {

    public static void main(String[] args) {
        Person person = new PersonBuilder()
                .with(personBuilder -> {
                    personBuilder.setFirstname("Mr.");
                    personBuilder.setLastname("John");
                    personBuilder.setNationality(Nationality.En);
                    try {
                        personBuilder.setBirthdate("01-01-1900");
                    } catch (InvalidValue | ParseException invalidValue) {
                        invalidValue.printStackTrace();
                    }
                })
                .createPerson();

        System.out.println(person);
    }
}
