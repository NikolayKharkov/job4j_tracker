package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int minus(int y) {
        return x - y;
    }

    public int divide(int y) {
        return x / y;
    }

    public int multiply(int y) {
        return x * y;
    }

    public static int sum(int y) {
        return x + y;
    }

    public int sumAllOperation(int y) {
        return minus(y) + divide(y) + multiply(y) + sum(y);
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println(Calculator.minus(5) + " " + "Работа static minus");
        System.out.println(calc.divide(5) + " " + "Работа not static divide");
        System.out.println(calc.sumAllOperation(5) + " " + "Работа not static sumAllOperation");
    }
}