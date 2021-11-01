package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book harryPotter = new Book("Harry Potter", 360);
        Book cleanCode = new Book("Clean code", 780);
        Book solaris = new Book("Solaris", 360);
        Book iAmLegend = new Book("I am legend", 780);
        Book[] library = new Book[4];
        library[0] = harryPotter;
        library[1] = cleanCode;
        library[2] = solaris;
        library[3] = iAmLegend;
        for (int i = 0; i < library.length; i++) {
            System.out.println(library[i].getName() + " " + library[i].getPages());
        }
        library[0] = iAmLegend;
        library[3] = harryPotter;
        for (int i = 0; i < library.length; i++) {
            if (library[i].getName().equals("Clean code")) {
                System.out.println(library[i].getName() + " " + library[i].getPages());
            }

        }

    }
}
