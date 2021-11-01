package ru.job4j.inheritance;

public class Dentist extends Doctor {

    private int numberHealthTeeth;

    public Dentist(String name, String surname, String education,
                   String birthday, String typeEducation, int numberHealthTeeth) {
        super(name, surname, education, birthday, typeEducation);
        this.numberHealthTeeth = numberHealthTeeth;
    }

    public int getNumberHealthTeeth() {
        return numberHealthTeeth;
    }
}