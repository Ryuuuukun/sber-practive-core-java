package ru.sber.base.syntax.other.calculator.parser;

import org.jetbrains.annotations.NotNull;
import ru.sber.base.syntax.other.calculator.CharSource;

import java.util.function.Predicate;

public class BaseParser {
    private static final char EOF = '\0';

    protected final CharSource source;

    protected char chr;

    public BaseParser(CharSource source) {
        this.source = source;

        this.take();
    }

    protected char take() {
        char tmp = chr;
        chr = source.hasNext() ? source.next() : EOF;
        return tmp;
    }

    protected boolean test(char expected) {
        return chr == expected;
    }

    protected boolean test(char min, char max) {
        return chr >= min && chr <= max;
    }

    protected boolean test(@NotNull Predicate<Character> predicate) {
        return predicate.test(chr);
    }

    private boolean skip(boolean value) {
        if (value) {
            take();
        }

        return value;
    }
    protected boolean skip(char chr) {
        return skip(test(chr));
    }

    protected boolean skip(char min, char max) {
        return skip(test(min, max));
    }

    protected boolean skip(@NotNull Predicate<Character> predicate) {
        return skip(test(predicate));
    }

    protected void expect(char expected) {
        if (!skip(expected)) {
            throw source.exception("Expected character '" + expected + "', received character '" + chr + "'");
        }
    }

    protected void expect(@NotNull final String token) {
        for (var c : token.toCharArray()) {
            expect(c);
        }
    }

    protected boolean eof() {
        return skip(EOF);
    }
}
