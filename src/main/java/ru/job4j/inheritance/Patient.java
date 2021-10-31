package ru.job4j.inheritance;

public class Patient {
    private String name;
    private Diagnose diagnose;

    public void setDiagnose(Diagnose diagnose) {
        this.diagnose = diagnose;
    }

    public Diagnose getDiagnose() {
        return diagnose;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}