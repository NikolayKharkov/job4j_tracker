package ru.job4j.oop;

public class College {
    public static void main(String[] args) {
        Freshman freshMeat = new Freshman();
        Student newStudent = freshMeat;
        Object graduate = newStudent;
    }
}
