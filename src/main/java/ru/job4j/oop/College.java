package ru.job4j.oop;

public class College {
    public static void main(String[] args) {
        Freshman newGuy = new Freshman();
        Student newStudent = newGuy;
        Object graduate = newStudent;
    }
}
