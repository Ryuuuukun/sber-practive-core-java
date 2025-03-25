package ru.sber.base.syntax.other.generics;

public class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person (name = " + this.name +
                    ", age = " + this.age + ")";
    }
}
