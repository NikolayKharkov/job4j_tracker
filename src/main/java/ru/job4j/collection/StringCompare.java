package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Arrays;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
       int result = left.length() - right.length();
       for (int i = 0; i < left.length(); i++) {
           if (i == left.length() || i == right.length()) {
               break;
           }
           result += Character.compare(left.charAt(i), right.charAt(i));
       }
       return result;
    }
}
