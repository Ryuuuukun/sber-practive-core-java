package ru.sber.base.syntax.excellent.calculator.expression;

public abstract class BinaryExpression implements Expression {
    private final Expression leftOperand;
    private final Expression rightOperand;

    private final String operand;

    public BinaryExpression(String operand, Expression leftOperand, Expression rightOperand) {
        this.operand = operand;
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    abstract public double operator(double a, double b);

    @Override
    public double evaluate() {
        return this.operator(leftOperand.evaluate(), rightOperand.evaluate());
    }

    @Override
    public String toString() {
        return "(" + leftOperand + " " + operand + " " + rightOperand + ")";
    }
}
