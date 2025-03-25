package ru.sber.base.syntax.other.generics;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class GenericCollection<T> {
    private final List<T> collection;

    public GenericCollection(List<T> collection) {
        this.collection = collection;
    }

    public GenericCollection() {
        this(new ArrayList<>());
    }

    public void add(@NotNull T element) {
        this.collection.add(element);
    }

    public void remove(int index) {
        this.collection.remove(index);
    }

    public T get(int index) {
        return this.collection.get(index);
    }

    public int size() {
        return this.collection.size();
    }

    public void printAll() {
        this.collection.forEach(System.out::println);
    }
}
