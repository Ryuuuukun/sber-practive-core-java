package ru.sber.base.syntax.other.calculator.translator;

import org.jetbrains.annotations.NotNull;
import ru.sber.base.syntax.other.calculator.expression.Expression;
import ru.sber.base.syntax.other.calculator.expression.binary.Addition;
import ru.sber.base.syntax.other.calculator.expression.binary.Divide;
import ru.sber.base.syntax.other.calculator.expression.binary.Multiply;
import ru.sber.base.syntax.other.calculator.expression.binary.Subtract;
import ru.sber.base.syntax.other.calculator.expression.unary.Constant;
import ru.sber.base.syntax.other.calculator.expression.unary.UnaryFunction;
import ru.sber.base.syntax.other.calculator.expression.unary.Variable;
import ru.sber.base.syntax.other.calculator.source.StringAssemblySource;

public class ExpressionAssemblyParser extends BaseAssemblyParser {
    public ExpressionAssemblyParser(StringAssemblySource source) {
        super(source);

        setSkipWhitespace(true);
    }

    public static Expression parse(@NotNull final String expression) {
        return new ExpressionAssemblyParser(new StringAssemblySource(expression))
                    .expression();
    }

    /**
     * An expression is a sequence of summands of one or more divided by additive operators
     *
     * <blockquote><pre>
     *     expression := summand { ( '+' | '-' ) summand } .
     * </pre></blockquote>
     * */
    protected Expression expression() {
        Expression result = summand();

        while (test('+') || test('-')) {
            if (skip('+')) {
                result = new Addition(result, summand());
            } else if (skip('-')) {
                result = new Subtract(result, summand());
            }
        }

        return result;
    }

    /**
     * A summand is a sequence consisting of one or more multipliers separated by multiplicative operators
     *
     * <blockquote><pre>
     *     summand := multiplier { ( '*' | '/' ) multiplier } .
     * </pre></blockquote>
     * */
    protected Expression summand() {
        Expression result = multiplier();

        while (test('*') || test('/')) {
            if (skip('*')) {
                result = new Multiply(result, multiplier());
            } else if (skip('/')) {
                result = new Divide(result, multiplier());
            }
        }

        return result;
    }

    /**
     * Multiplier is a number, a functional variable, or a bracketed expression
     *
     * <blockquote><pre>
     *     multiplier := number | functionality | '(' expression ')'.
     * </pre></blockquote>
     * */
    protected Expression multiplier() {
        if (test('-') || test('+') || test(Character::isDigit)) {
            return number();
        } else if (test('(')) {
            expect('(');
            Expression result = expression();
            expect(')');
            return result;
        } else {
            return functionality();
        }
    }

    /**
     * functional variable - a variable with a name declaration and an overloaded
     * operator, if a functional variable does not have an overloaded operator, it is
     * considered just a variable.
     *
     * <blockquote><pre>
     *     functionality := identifier [ '(' expression ')' ] .
     * </pre></blockquote>
     * */
    protected Expression functionality() {
        String identifier = identifier();

        if (test('(')) {
            expect('(');
            Expression expression = expression();
            expect(')');

            return new UnaryFunction(identifier, expression);
        } else {
            return new Variable(identifier);
        }
    }

    /**
     * Identifier - a sequence consisting of one or more characters of letters, digits
     * or underscore, the identifier must begin with a letter.
     *
     * <blockquote><pre>
     *     identifier := letter { letter | digit | '_' } .
     * </pre></blockquote>
     * */
    protected String identifier() {
        StringBuilder builder = new StringBuilder();
        if (test(Character::isLetter)) {
            do {
                builder.append(take());
            } while (test(Character::isLetter) || test(Character::isDigit) || test('_'));

            return builder.toString();
        } else {
            throw exception("The identifier must begin with a letter");
        }
    }

    /**
     * The following number formats are supported:
     * <ul>
     *     <li>integer signed number (unsigned)</li>
     *     <li>fractional signed number (unsigned)</li>
     *     <li>The exponential form of number recording is supported</li>
     * </ul>
     *
     * <blockquote><pre>
     *     number := [ '-' | '+' ] nonzero-digit { digit } [ '.' { digit } ] [ ( 'e' | 'E' ) [ '+' | '-' ] { digit } ] .
     * </pre></blockquote>
     * */
    protected Expression number() {
        StringBuilder number = new StringBuilder();

        if (test('-') || test('+')) {
            number.append(take());
        }

        if (test('0')) {
            number.append(take());
        } else if (test(Character::isDigit)) {
            do {
                number.append(take());
            } while (test(Character::isDigit));
        } else {
            throw exception("A numeric literal was expected");
        }

        if (test('.')) {
            do {
                number.append(take());
            } while (test(Character::isDigit));
        }
        if (test('e') || test('E')) {
            number.append(take());
            if (test('-') || test('+')) {
                number.append(take());
            }
            if (test(Character::isDigit)) {
                do {
                    number.append(take());
                } while (test(Character::isDigit));
            } else {
                throw exception("The degree of exponent was expected");
            }
        }

        return new Constant(Double.parseDouble(number.toString()));
    }
}
