package ru.sber.base.syntax.other.calculator.source;

public class StringAssemblySource implements AssemblySource {
    private final String source;

    private int mark;
    private int pos;

    public StringAssemblySource(String source) {
        this.source = source;

        this.mark = -1;
        this.pos = 0;
    }

    @Override
    public char next() {
        return source.charAt(pos++);
    }

    @Override
    public void mark() {
        mark = pos;
    }

    @Override
    public void back() {
        pos = mark != -1 ? mark : pos;
    }

    @Override
    public boolean hasNext() {
        return pos < source.length();
    }

    @Override
    public IllegalArgumentException exception(String message) {
        return new IllegalArgumentException("Exception on " + pos + ": " + message);
    }
}
