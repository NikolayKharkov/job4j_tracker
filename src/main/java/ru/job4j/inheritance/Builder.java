package ru.job4j.inheritance;

public class Builder extends Engineer {

    private int createdHouses;

    public Builder(String name, String surname,
                   String education, String birthday, int successfulProjects, int createdHouses) {
        super(name, surname, education, birthday, successfulProjects);
        this.createdHouses = createdHouses;

    }

    public int getCreatedHouses() {
        return createdHouses;
    }

}