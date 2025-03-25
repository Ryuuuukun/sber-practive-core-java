package ru.sber.base.syntax.other.calculator.expression.unary;

import ru.sber.base.syntax.other.calculator.expression.Expression;

import java.util.function.UnaryOperator;

public class FunctionExpression implements Expression {
    private final Expression expression;
    private final UnaryOperator<Double> operator;
    private final String token;

    public FunctionExpression(Expression expression, UnaryOperator<Double> operator, String token) {
        this.expression = expression;
        this.operator = operator;
        this.token = token;
    }

    @Override
    public double evaluate() {
        return operator.apply(expression.evaluate());
    }

    @Override
    public String toString() {
        if (expression instanceof Constant) {
            return token + "(" + expression + ")";
        } else {
            return token + expression;
        }
    }
}
