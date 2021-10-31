package ru.job4j.oop;

public class User {
    private String name; /*Поле объекта т.к объявлена внутри класса*/
    private int age;     /*Поле объекта т.к объявлена внутри класса*/

    public boolean canDrive() {
        boolean can = false; /*Локальная переменная  т.к объявлена внутри метода*/
        if (age >= 18) {
            can = true;
        }
        return can;
    }
}