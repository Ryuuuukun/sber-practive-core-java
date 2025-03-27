package ru.sber.base.syntax.other.calculator.expression.binary;

import ru.sber.base.syntax.other.calculator.expression.Expression;

public class Subtract extends BinaryExpression {
    public Subtract(Expression left, Expression right) {
        super(left, right, "-");
    }

    @Override
    protected double operator(double a, double b) {
        return a - b;
    }
}
