package ru.job4j.oop;

public class Reduce {
    private int[] array;

    public void to(int[] arrayInput) {
        this.array = arrayInput;
    }

    public void print() {
        for (int index = 0; index < this.array.length; index++) {
            System.out.println(this.array[index]);
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        Reduce reduce = new Reduce();
        reduce.to(array);
        reduce.print();
        /*Прична ошибки была в следующем: */
        /*в методе to была локальная переменная array, а не поле класса*/
        /*следовательно, в метод передавалась пустая коллекция*/
    }
}