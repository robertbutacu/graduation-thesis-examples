package com.graduation.examples.design.patterns.factory.gifts;

public class Nothing implements Gift {
    @Override
    public String message() {
        return "YOU WON NOTHING!";
    }
}
