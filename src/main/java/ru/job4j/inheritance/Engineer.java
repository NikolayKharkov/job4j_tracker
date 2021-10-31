package ru.job4j.inheritance;

public class Engineer extends Profession {

    private int successfulProjects;

    Engineer() {
    }

    Engineer(int successfulProjects) {

        this.successfulProjects = successfulProjects;
    }

    public int getSuccessfulProjects() {

        return successfulProjects;
    }
}