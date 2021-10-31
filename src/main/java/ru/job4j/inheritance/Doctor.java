package ru.job4j.inheritance;

public class Doctor extends Profession {

    private String typeEducation;

    Doctor() {
    }

    Doctor(String typeEducation) {
        this.typeEducation = typeEducation;
    }

    public String gettypeEducation() {
        return typeEducation;
    }

}