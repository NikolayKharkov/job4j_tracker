package ru.job4j.inheritance;

public class Engineer extends Profession {

    private int successfulProjects;

    public Engineer(String name, String surname,
                    String education, String birthday, int successfulProjects) {
        super(name, surname, education, birthday);
        this.successfulProjects = successfulProjects;

    }

    public int getSuccessfulProjects() {

        return successfulProjects;
    }
}