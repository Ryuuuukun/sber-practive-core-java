package ru.sber.base.syntax.other.calculator.translator;

import org.jetbrains.annotations.NotNull;
import ru.sber.base.syntax.other.calculator.source.StringAssemblySource;

import java.util.concurrent.Callable;
import java.util.function.Predicate;

public class BaseAssemblyParser {
    private final StringAssemblySource source;

    private char ch;

    private boolean skipWS;

    public BaseAssemblyParser(StringAssemblySource source) {
        this.source = source;
        this.skipWS = false;

        take();
    }

    protected boolean eof() {
        return ch == '\0';
    }

    protected char take() {
        char tmp = ch;
        do {
            ch = source.hasNext() ? source.next() : '\0';
        } while (skipWS && Character.isWhitespace(ch));
        return tmp;
    }

    protected boolean test(char expected) {
        return ch == expected;
    }

    protected boolean test(char min, char max) {
        return ch >= min && ch <= max;
    }

    protected boolean test(@NotNull Predicate<Character> predicate) {
        return predicate.test(ch);
    }

    private boolean skip(boolean value) {
        if (value) {
            take();
        }

        return value;
    }

    protected boolean skip(char expected) {
        return skip(test(expected));
    }

    protected boolean skip(char min, char max) {
        return skip(test(min, max));
    }

    protected boolean skip(@NotNull Predicate<Character> predicate) {
        return skip(test(predicate));
    }

    protected void expect(char expected) {
        if (!skip(expected)) {
            throw source.exception("Expected character '" + expected + "' received character '" + ch + "'");
        }
    }

    protected void expect(@NotNull final String token) {
        for (var c : token.toCharArray()) {
            expect(c);
        }
    }

    protected <T> T maybe(@NotNull Callable<T> callable) {
        source.mark();
        try {
            return callable.call();
        } catch (IllegalArgumentException e) {
            source.back();
        } catch (Exception e) {
            source.back();
            throw new RuntimeException(e);
        }

        return null;
    }

    protected void setSkipWhitespace(boolean state) {
        skipWS = state;
    }

    protected void inverseSkipWhitespace() {
        skipWS = !skipWS;
    }

    protected IllegalArgumentException exception(@NotNull final String message) {
        return source.exception(message);
    }
}
