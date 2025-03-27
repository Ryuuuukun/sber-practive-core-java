package ru.sber.base.syntax.other.calculator.expression;

import java.util.Map;

public interface Expression {
    double evaluate(Map<String, Object> args);
}
