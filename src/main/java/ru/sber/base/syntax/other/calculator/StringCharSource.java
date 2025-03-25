package ru.sber.base.syntax.other.calculator;

public class StringCharSource implements CharSource {
    private final String source;
    private int pos;

    public StringCharSource(String source) {
        this.source = source;
        this.pos = 0;
    }

    @Override
    public boolean hasNext() {
        return pos < source.length();
    }

    @Override
    public char next() {
        return source.charAt(pos++);
    }

    @Override
    public IllegalArgumentException exception(final String message) {
        return new IllegalArgumentException("Exception on " + pos + ": " + message);
    }
}
