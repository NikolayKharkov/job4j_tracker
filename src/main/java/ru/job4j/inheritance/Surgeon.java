package ru.job4j.inheritance;

public class Surgeon extends Doctor {

    private int successfulOperations;

    Surgeon() {
    }

    Surgeon(int successfulOperations) {
        this.successfulOperations = successfulOperations;
    }

    public int getSuccessfulOperations() {
        return successfulOperations;
    }

}