package ru.job4j.inheritance;

public class Programmer extends Engineer {

    private int languagesNumbers;

    public Programmer(String name, String surname,
                      String education, String birthday, int successfulProjects,
                      int createdHouses, int languagesNumbers) {
        super(name, surname, education, birthday, successfulProjects);
        this.languagesNumbers = languagesNumbers;
    }

    public int getLanguagesNumbers() {
        return languagesNumbers;
    }

}