package ru.job4j.pojo;

public class Bus implements Vehicle {

    @Override
    public void move() {
        System.out.println("Автобус перевозит людей");
    }
}

