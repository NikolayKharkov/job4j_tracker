package ru.job4j.inheritance;

public class Surgeon extends Doctor {

    private int successfulOperations;

    public Surgeon(String name, String surname, String education,
                   String birthday, String typeEducation, int successfulOperations) {
        super(name, surname, education, birthday, typeEducation);
        this.successfulOperations = successfulOperations;
    }

    public int getSuccessfulOperations() {
        return successfulOperations;
    }

}