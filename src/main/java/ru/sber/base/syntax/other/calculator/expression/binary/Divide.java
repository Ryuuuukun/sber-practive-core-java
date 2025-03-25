package ru.sber.base.syntax.other.calculator.expression.binary;

import ru.sber.base.syntax.other.calculator.expression.BinaryExpression;
import ru.sber.base.syntax.other.calculator.expression.Expression;

public class Divide extends BinaryExpression {
    public Divide(Expression leftOperand, Expression rightOperand) {
        super("/", leftOperand, rightOperand);
    }

    @Override
    public double operator(double a, double b) {
        return a / b;
    }
}
