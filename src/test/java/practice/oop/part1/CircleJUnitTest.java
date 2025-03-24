package practice.oop.part1;

import org.junit.Assert;
import org.junit.Test;
import ru.sber.base.syntax.oop.part1.circle.Circle;

import java.awt.*;

public class CircleJUnitTest {

    @Test
    public void initTest() {
        Circle a = new Circle(2.0, Color.RED);
        Circle b = new Circle(1.0 / Math.PI, Color.PINK);
    }

    @Test
    public void methodsCircleTest() {
        Circle a = new Circle(1.0, Color.RED);
        Circle b = new Circle(1.0 / Math.PI, Color.PINK);

        Assert.assertEquals(Math.PI, a.area(), 1e-10);
        Assert.assertEquals(1.0 / Math.PI, b.area(), 1e-10);

        Assert.assertEquals(2.0 * Math.PI, a.perimeter(), 1e-10);
        Assert.assertEquals(2.0, b.perimeter(), 1e-10);
    }

    @Test
    public void toStringTest() {
        System.out.println(new Circle(1.0, Color.RED));
        System.out.println(new Circle(2.0, Color.BLACK));
    }
}
