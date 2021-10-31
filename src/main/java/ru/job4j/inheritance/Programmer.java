package ru.job4j.inheritance;

public class Programmer extends Engineer {

    private int languagesNumbers;

    Programmer() {
    }

    Programmer(int languagesNumbers) {
        this.languagesNumbers = languagesNumbers;
    }

    public int getLanguagesNumbers() {
        return languagesNumbers;
    }

}