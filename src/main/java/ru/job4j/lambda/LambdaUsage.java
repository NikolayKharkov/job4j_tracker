package ru.job4j.lambda;

import java.util.Comparator;

public class LambdaUsage {
    public static void main(String[] args) {
        Comparator<String> cmpText = (left, right) -> {
            System.out.println("compare desc" + left + " " + right + "by compareTo");
            return right.compareTo(left);
        };
        Comparator<String> cmpDescSize = (left, right) -> {
            System.out.println("compare desc" + left + " " + right + "by str length");
            return Integer.compare(right.length(), left.length());
        };
    }
}
