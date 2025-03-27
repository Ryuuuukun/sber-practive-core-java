package ru.sber.base.syntax.other.calculator.expression.unary;

import ru.sber.base.syntax.other.calculator.expression.Expression;

import java.util.Map;

public class Variable implements Expression {
    private final String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public double evaluate(Map<String, Object> args) {
        return switch (name.toLowerCase()) {
            case "pi" -> Math.PI;
            case "e"  -> Math.E;
            default -> (double) args.get(name);
        };
    }

    @Override
    public String toString() {
        return name;
    }
}
