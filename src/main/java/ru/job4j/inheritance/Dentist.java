package ru.job4j.inheritance;

public class Dentist extends Doctor {

    private int numberHealthTeeth;

    Dentist() {
    }

    Dentist(int numberHealthTeeth) {
        this.numberHealthTeeth = numberHealthTeeth;
    }

    public int getNumberHealthTeeth() {
        return numberHealthTeeth;
    }

}