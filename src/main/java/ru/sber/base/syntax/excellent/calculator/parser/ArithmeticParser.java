package ru.sber.base.syntax.excellent.calculator.parser;

import ru.sber.base.syntax.excellent.calculator.CharSource;
import ru.sber.base.syntax.excellent.calculator.StringCharSource;
import ru.sber.base.syntax.excellent.calculator.expression.*;
import ru.sber.base.syntax.excellent.calculator.expression.binary.Add;
import ru.sber.base.syntax.excellent.calculator.expression.binary.Divide;
import ru.sber.base.syntax.excellent.calculator.expression.binary.Multiply;
import ru.sber.base.syntax.excellent.calculator.expression.binary.Subtract;
import ru.sber.base.syntax.excellent.calculator.expression.unary.Constant;
import ru.sber.base.syntax.excellent.calculator.expression.unary.FunctionExpression;

public class ArithmeticParser extends BaseParser {
    private ArithmeticParser(CharSource source) {
        super(source);
    }

    public static Expression parse(final String source) {
        return new ArithmeticParser(new StringCharSource(source))
                .expression();
    }

    /**
     * Definition of expression, the Extended Backus-Naur form is used
     *
     * <blockquote><pre>
     *    expression := ws summand { ws operator-summing ws summand } ws .
     * </pre></blockquote><p>
     * */
    protected Expression expression() {
        whitespace();
        Expression result = summand();

        whitespace();
        while (!eof() && testAdditionOperator()) {
            whitespace();

            if (skip('+')) {
                whitespace();
                result = new Add(result, summand());
            } else if (skip('-')) {
                whitespace();
                result = new Subtract(result, summand());
            } else {
                throw source.exception("An addition operator was expected");
            }

            whitespace();
        }
        whitespace();

        return result;
    }

    /**
     * Definition of summand, the Extended Backus-Naur form is used
     *
     * <blockquote><pre>
     *    summand := multiplier { ws operator-multiplication ws multiplier } .
     * </pre></blockquote><p>
     * */
    public Expression summand() {
        Expression result = multiplier();

        whitespace();
        while (!eof() && testMultiplicationOperator()) {
            whitespace();

            if (skip('*')) {
                whitespace();
                result = new Multiply(result, multiplier());
            } else if (skip('/')) {
                whitespace();
                result = new Divide(result, multiplier());
            } else {
                throw source.exception("An multiplication operator was expected");
            }

            whitespace();
        }

        return result;
    }

    /**
     * Definition of multiplier, the Extended Backus-Naur form is used
     *
     * <blockquote><pre>
     *    multiplier := number | unary-function | '(' ws expression ws ')' .
     * </pre></blockquote><p>
     * */
    public Expression multiplier() {
        if (testSign() || test(Character::isDigit)) {
            return number();
        } else if (skip('(')) {
            whitespace();
            Expression expression = expression();
            whitespace();
            expect(')');
            return expression;
        } else if (test('s') || test('c')) {
            return unaryFunction();
        } else {
            throw source.exception("Undefined multiplier");
        }
    }



    public Expression unaryFunction() {
        if (skip('s')) {
            expect("in(");
            Expression expression = expression();
            expect(')');
            return new FunctionExpression(expression, Math::sin, "sin");
        } else if (skip('c')) {
            expect("os(");
            Expression expression = expression();
            expect(')');
            return new FunctionExpression(expression, Math::cos, "cos");
        } else {
            throw source.exception("Unary function expected");
        }
    }

    /**
     * Definition of multiplier, the Extended Backus-Naur form is used
     *
     * <blockquote><pre>
     *    sign := '+' | '-' .
     *
     *    number := [ sign ] ( '0' | { digit } ) [ ( '.' { digit } ) | ( ( 'e' | 'E' ) [ sign ] digit { digit } ) ] .
     * </pre></blockquote><p>
     * */
    public Expression number() {
        StringBuilder number = new StringBuilder();

        if (testSign()) {
            number.append(take());
        }

        if (test('0')) {
            number.append(take());
        } else {
            number.append(digits());
        }

        if (test('.')) {
            number.append(take()).append(digits());
        } else if (testExponent()) {
            number.append(take());

            if (testSign()) {
                number.append(take());
            }

            if (test(Character::isDigit)) {
                number.append(take()).append(digits());
            } else {
                throw source.exception("Incorrect number format, exponent degree was expected");
            }
        }

        return new Constant(Double.parseDouble(number.toString()));
    }

    protected String digits() {
        StringBuilder result = new StringBuilder();
        while (test(Character::isDigit)) {
            result.append(take());
        }
        return result.toString();
    }

    protected boolean testExponent() {
        return test('e') || test('E');
    }

    protected boolean testSign() {
        return test('+') | test('-');
    }

    public boolean testAdditionOperator() {
        return test('+') || test('-');
    }

    public boolean testMultiplicationOperator() {
        return test('*') || test('/');
    }

    protected void whitespace() {
        while (skip(Character::isWhitespace)) {

        }
    }
}
