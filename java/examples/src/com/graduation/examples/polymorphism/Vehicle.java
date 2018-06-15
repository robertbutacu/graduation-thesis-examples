package com.graduation.examples.polymorphism;

public abstract class Vehicle {
    public abstract int wheels();
}

class Bicyle extends Vehicle {
    @Override
    public int wheels() {
        return 2;
    }
}

class Car extends Vehicle {
    @Override
    public int wheels() {
        return 4;
    }
}
