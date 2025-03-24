package ru.sber.base.syntax.oop.part1.book;

public class Author {
    private String name;
    private AuthorGender gender;

    private String email;

    public Author(String name, AuthorGender gender, String email) {
        this.name = name;
        this.gender = gender;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Автор " + this.name + ", пол: " + this.gender + ", почта: " + this.email;
    }

    public String getName() {
        return name;
    }

    public AuthorGender getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(AuthorGender gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
