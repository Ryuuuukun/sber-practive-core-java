package ru.sber.base.syntax.other.calculator;

import org.jetbrains.annotations.NotNull;
import ru.sber.base.syntax.other.calculator.translator.ExpressionAssemblyParser;

import java.util.Map;

public final class Calculator {
    public static double evaluate(@NotNull final String expression, Map<String, Object> args) {
        return ExpressionAssemblyParser.parse(expression)
                .evaluate(args);
    }

    public static double evaluate(@NotNull final String expression) {
        return ExpressionAssemblyParser.parse(expression)
                .evaluate(Map.of());
    }

    public static String canonical(@NotNull final String expression) {
        return ExpressionAssemblyParser.parse(expression).toString();
    }
}
