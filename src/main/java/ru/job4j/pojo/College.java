package ru.job4j.pojo;

import java.util.Date;
import java.time.format.DateTimeFormatter;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFirstName("Иван");
        student.setLastName("Иванов");
        student.setMiddleName("Иванович");
        student.setGroup("Группа С");
        student.setReceiptDate(new Date());

        System.out.println("Информация о студенте:");
        System.out.printf("ФИО : %s %s %s\n", student.getLastName(),
                student.getFirstName(),
                student.getMiddleName());
        System.out.printf("Группа : %s\n", student.getGroup());
        System.out.printf("Дата зачисления  : %s\n", student.getReceiptDate());
    }
}
