package ru.sber.base.syntax.other.calculator.expression.unary;

import ru.sber.base.syntax.other.calculator.expression.Expression;

import java.util.Map;

public class UnaryFunction implements Expression {
    private final String identifier;

    private final Expression expression;

    public UnaryFunction(String identifier, Expression expression) {
        this.identifier = identifier;
        this.expression = expression;
    }

    @Override
    public double evaluate(Map<String, Object> args) {
        return switch (identifier.toLowerCase()) {
            case "sin" -> Math.sin(expression.evaluate(args));
            case "cos" -> Math.cos(expression.evaluate(args));
            case "tan" -> Math.tan(expression.evaluate(args));
            case "abs" -> Math.abs(expression.evaluate(args));
            case null, default -> throw new IllegalArgumentException("sdf");
        };
    }

    @Override
    public String toString() {
        if (expression instanceof Constant || expression instanceof Variable || expression instanceof UnaryFunction) {
            return identifier + "(" + expression + ")";
        } else {
            return identifier + expression;
        }
    }
}
