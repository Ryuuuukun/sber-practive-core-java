package practice.oop.part1;

import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.junit.Test;
import ru.sber.base.syntax.oop.part1.matrix.Matrix;

public class MatrixJUnitTest {

    @Test
    public void initTest() {
        Matrix a = Matrix.from(2, 2, "1.0 0.0 1.2 1.3");
        Matrix b = new Matrix(2, 2);
        Matrix c = new Matrix(a);
    }

    @Test
    public void transformOperationTest() {
        Matrix a = Matrix.from(2, 2, "1.0 1.0 1.0 1.0");

        a.add(1.0);
        assertMatrixEquals(a, Matrix.from(2, 2, "2.0 2.0 2.0 2.0"));

        a.mul(2.0);
        assertMatrixEquals(a, Matrix.from(2, 2, "4.0 4.0 4.0 4.0"));

        a.sub(4.0);
        assertMatrixEquals(a, Matrix.from(2, 2, "0.0 0.0 0.0 0.0"));
    }

    @Test
    public void mergeOperationTest() {
        Matrix a = Matrix.from(2, 2, "1.0 0.0 0.0 1.0");
        Matrix b = Matrix.from(2, 2, "1.0 2.0 3.0 4.0");

        assertMatrixEquals(a.add(b), Matrix.from(2, 2, "2.0 2.0 3.0 5.0"));
        assertMatrixEquals(a.mul(b), Matrix.from(2, 2, "1.0 2.0 3.0 4.0"));
        assertMatrixEquals(a.sub(b), Matrix.from(2, 2, "0.0 -2.0 -3.0 -3.0"));
    }

    @Test
    public void toStringTest() {
        System.out.println(Matrix.from(2, 2, "1.0 0.0 0.0 1.0"));
        System.out.println(Matrix.from(2, 2, "1.0 2.0 3.0 4.0"));
    }

    private void assertMatrixEquals(@NotNull final Matrix a, @NotNull final Matrix b) {
        Assert.assertEquals("The number of rows does not match",
                a.getRows(), b.getRows());
        Assert.assertEquals("The number of cols does not match",
                a.getCols(), b.getCols());

        for (int i = 0; i < a.getRows(); ++i) {
            for (int j = 0; j < a.getCols(); ++j) {
                Assert.assertEquals(a.getValue(i, j), b.getValue(i, j), 1e-10);
            }
        }
    }
}
