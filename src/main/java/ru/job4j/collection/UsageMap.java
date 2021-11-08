package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        Map<String, String> users = new HashMap<>();
        users.put("Ivan96@yandex.ru", "Ivan");
        users.put("Anna98@gmail.com", "Anna");
        for (String userKey : users.keySet()) {
            System.out.println("Почта: " + userKey + " Имя: " + users.get(userKey));
        }
    }
}
