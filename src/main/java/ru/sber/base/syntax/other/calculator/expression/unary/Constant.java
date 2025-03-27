package ru.sber.base.syntax.other.calculator.expression.unary;

import ru.sber.base.syntax.other.calculator.expression.Expression;

import java.util.Map;

public class Constant implements Expression {
    private final double value;

    public Constant(double value) {
        this.value = value;
    }

    @Override
    public double evaluate(Map<String, Object> args) {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
