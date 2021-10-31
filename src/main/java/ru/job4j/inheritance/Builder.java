package ru.job4j.inheritance;

public class Builder extends Engineer {

    private int createdHouses;

    Builder() {
    }

    Builder(int createdHouses) {
        this.createdHouses = createdHouses;
    }

    public int getCreatedHouses() {
        return createdHouses;
    }

}