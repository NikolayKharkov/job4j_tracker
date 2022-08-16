package ru.job4j.gc.leak;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserGenerator implements Generate {

    private static final String PATH_NAME = "src/main/java/ru/job4j/gc/leak/files/names.txt";
    private static final String PATH_SURNAMES = "src/main/java/ru/job4j/gc/leak/files/surnames.txt";
    private static final String PATH_PATRONS = "src/main/java/ru/job4j/gc/leak/files/patr.txt";
    private static final int USERS_COUNT = 1000;
    private final String lineSeparator;

    private List<String> names;
    private List<String> surnames;
    private List<String> patrons;
    private List<User> users = new ArrayList<>(USERS_COUNT);
    private Random random;

    public UserGenerator(Random random, String lineSeparator) {
        this.random = random;
        this.lineSeparator = lineSeparator;
        readAll();
    }

    @Override
    public void generate() {
        users.clear();
        for (int i = 0; i < USERS_COUNT; i++) {
            StringBuilder userName = new StringBuilder();
            userName
                    .append(random.nextInt(surnames.size()))
                    .append(lineSeparator)
                    .append(random.nextInt(names.size()))
                    .append(lineSeparator).append(random.nextInt(patrons.size()));
            users.add(new User(userName.toString()));
        }
    }

    private void readAll() {
        try {
            names = read(PATH_NAME);
            surnames = read(PATH_SURNAMES);
            patrons = read(PATH_PATRONS);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public User randomUser() {
        return users.get(random.nextInt(users.size()));
    }

    public List<User> getUsers() {
        return users;
    }
}