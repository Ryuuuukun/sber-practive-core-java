package practice.other;

import org.junit.Assert;
import org.junit.Test;
import ru.sber.base.syntax.other.calculator.Calculator;

public class CalculatorJUnitTest {

    @Test
    public void summandTest() {
        Assert.assertEquals(10.0, Calculator.evaluate("1 + 2 + 3 + 4"), 1e-10);
        Assert.assertEquals(-2.0, Calculator.evaluate("1 - 2 + 3 - 4"), 1e-10);
        Assert.assertEquals(10.0, Calculator.evaluate("1 - -2 + 3 - -4"), 1e-10);
    }

    @Test
    public void multiplicationTest() {
        Assert.assertEquals(15, Calculator.evaluate("1.5 * 10.0"), 1e-10);
        Assert.assertEquals(Double.POSITIVE_INFINITY, Calculator.evaluate("1.0 / 0.0"), 1e-10);
        Assert.assertEquals(Double.NEGATIVE_INFINITY, Calculator.evaluate("1.0 / -0.0"), 1e-10);
    }

    @Test
    public void summandAndMultiplicationTest() {
        Assert.assertEquals(10.0, Calculator.evaluate("2.5 * 2 + 5.0"), 1e-10);
        Assert.assertEquals(10.0, Calculator.evaluate("(2.5 + 2.5) * 2.0"), 1e-10);
    }

    @Test
    public void unaryFunctionTest() {
        Assert.assertEquals(Double.NaN, Calculator.evaluate("sin(1.0 / 0.0)"), 1e-10);
        Assert.assertEquals(Math.sin(2.5 / 123e1), Calculator.evaluate("sin(2.5 / 123e1)"), 1e-10);
        Assert.assertEquals(Math.cos(12e-5 + 5e-10), Calculator.evaluate("cos(12e-5 + 5e-10)"), 1e-10);
    }

    @Test
    public void bracketsTest() {
        Assert.assertEquals(0, Calculator.evaluate("((((((((((((((0))))))))))))))"), 1e-10);
    }
}
