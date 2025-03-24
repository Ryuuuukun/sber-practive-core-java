package ru.sber.base.syntax.oop.part1.book;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // инициализация
        Book a = new Book("Война и мир", new Author("Л. Н. Толстой", AuthorGender.MAN, "-"),
                LocalDate.parse("1867-01-01"));

        // вывод информации о книге
        System.out.println(a);

        // вывод информации об авторе
        System.out.println(a.getAuthor());
    }
}
