package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class IntroduceStream {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        Collections.addAll(numbers, -3, -2, -1, 0, 1, 2, 3);
        List<Integer> onlyPosNums = numbers.stream().filter(num -> num > 0).
                collect(Collectors.toList());
        System.out.println(onlyPosNums);
    }
}
