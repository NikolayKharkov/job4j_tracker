package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int result = 0;
        String[] first = o1.split("/");
        String[] second = o2.split("/");
        for (int i = 0; i < Math.min(first.length, second.length); i++) {
            if (i == 0) {
                result = second[i].compareTo(first[i]);
            }
            if (result != 0) {
                break;
            }
            result = first[i].compareTo(second[i]);
        }
        return result == 0 ? Integer.compare(first.length, second.length) : result;
    }
}