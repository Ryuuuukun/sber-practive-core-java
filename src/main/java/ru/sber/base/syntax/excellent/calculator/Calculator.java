package ru.sber.base.syntax.excellent.calculator;

import ru.sber.base.syntax.excellent.calculator.parser.ArithmeticParser;

public class Calculator {
    public static double evaluate(final String expression) {
        return ArithmeticParser.parse(expression)
                .evaluate();
    }

    public static String canonical(final String expression) {
        return ArithmeticParser.parse(expression).toString();
    }
}
