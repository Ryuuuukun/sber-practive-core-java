package ru.sber.base.syntax.other.calculator.source;

public interface AssemblySource {
    char next();

    void mark();

    void back();

    boolean hasNext();

    IllegalArgumentException exception(String message);
}
