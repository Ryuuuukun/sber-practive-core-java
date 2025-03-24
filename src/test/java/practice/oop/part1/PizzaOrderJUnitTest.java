package practice.oop.part1;

import org.junit.Test;
import ru.sber.base.syntax.oop.part1.pizza.PizzaOrder;
import ru.sber.base.syntax.oop.part1.pizza.PizzaSize;

public class PizzaOrderJUnitTest {

    @Test
    public void initTest() {
        PizzaOrder order = new PizzaOrder("Аль-Капчоне", "Ярославская", PizzaSize.BIG, false);
    }

    @Test
    public void methodsPizzaOrderTest() {
        PizzaOrder order = new PizzaOrder("Аль-Капчоне", "Ярославская", PizzaSize.BIG, false);

        order.order();
        order.order();
        order.cancel();
        order.cancel();
    }

    @Test
    public void toStringTest() {
        System.out.println(new PizzaOrder("Аль-Капчоне", "Ярославская", PizzaSize.BIG, false));
    }
}
