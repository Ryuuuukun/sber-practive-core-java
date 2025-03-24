package ru.sber.base.syntax.oop.part1.book;

import java.time.LocalDate;

public class Book {
    private String name;

    private Author author;

    private LocalDate date;

    public Book(String name, Author author, LocalDate date) {
        this.name = name;
        this.author = author;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Книга  «" + this.name + "» написанная автором " + this.author.getName() +
                " и выпущенная в " + this.date.toString();
    }

    public String getName() {
        return name;
    }

    public Author getAuthor() {
        return author;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
