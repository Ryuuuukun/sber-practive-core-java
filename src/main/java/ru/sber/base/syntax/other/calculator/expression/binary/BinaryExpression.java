package ru.sber.base.syntax.other.calculator.expression.binary;

import ru.sber.base.syntax.other.calculator.expression.Expression;

import java.util.Map;

public abstract class BinaryExpression implements Expression {
    private final Expression left;
    private final Expression right;

    private final String token;

    public BinaryExpression(Expression left, Expression right, String token) {
        this.left = left;
        this.right = right;
        this.token = token;
    }

    abstract protected double operator(double a, double b);

    @Override
    public double evaluate(Map<String, Object> args) {
        return operator(left.evaluate(args), right.evaluate(args));
    }

    @Override
    public String toString() {
        return "(" + left + " " + token + " " + right + ")";
    }
}
