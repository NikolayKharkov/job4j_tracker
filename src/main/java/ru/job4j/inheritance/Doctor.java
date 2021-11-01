package ru.job4j.inheritance;

public class Doctor extends Profession {

    private String typeEducation;

    public Doctor(String name, String surname, String education,
                  String birthday, String typeEducation) {
        super(name, surname, education, birthday);
        this.typeEducation = typeEducation;
    }

    public String gettypeEducation() {
        return typeEducation;
    }
}