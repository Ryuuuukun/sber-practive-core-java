package ru.sber.base.syntax.oop.part1.book;

public enum AuthorGender {
    MAN("мужской"),
    FEMALE("женский");

    private final String string;

    AuthorGender(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return this.string;
    }
}
