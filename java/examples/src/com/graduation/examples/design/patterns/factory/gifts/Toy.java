package com.graduation.examples.design.patterns.factory.gifts;

public class Toy implements Gift {
    @Override
    public String message() {
        return "You won a toy! Be happy";
    }
}
