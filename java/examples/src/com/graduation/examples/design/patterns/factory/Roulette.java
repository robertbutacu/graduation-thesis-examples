package com.graduation.examples.design.patterns.factory;


import com.graduation.examples.design.patterns.factory.gifts.*;

import java.util.Scanner;

public class Roulette {
    public void run() throws InterruptedException {
        while (true) {
            Scanner input = new Scanner(System.in);

            System.out.println("Let's see what the russian roulette will give you");

            System.out.println(generateGift(GiftType.randomGift()).message());

            Thread.sleep(3000);
        }
    }

    public Gift generateGift(GiftType gift) {
        switch (gift) {
            case Drink:
                return new Drink();
            case Car:
                return new Car();
            case Nothing:
                return new Nothing();
            case Toy:
                return new Toy();
            case Error:
                return new Nothing();
            default:
                return new Nothing();
        }
    }
}
