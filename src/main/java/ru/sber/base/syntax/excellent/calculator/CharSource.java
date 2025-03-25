package ru.sber.base.syntax.excellent.calculator;

public interface CharSource {

    /**
     * Check if the following character is available
     * */
    boolean hasNext();

    /**
     * Read the following character
     * */
    char next();

    /**
     * Get an exception, to determine the location of the error
     * */
    IllegalArgumentException exception(String message);
}
