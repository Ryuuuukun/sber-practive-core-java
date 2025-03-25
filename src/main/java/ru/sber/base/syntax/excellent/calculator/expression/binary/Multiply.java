package ru.sber.base.syntax.excellent.calculator.expression.binary;

import ru.sber.base.syntax.excellent.calculator.expression.BinaryExpression;
import ru.sber.base.syntax.excellent.calculator.expression.Expression;

public class Multiply extends BinaryExpression {
    public Multiply(Expression leftOperand, Expression rightOperand) {
        super("*", leftOperand, rightOperand);
    }

    @Override
    public double operator(double a, double b) {
        return a * b;
    }
}
