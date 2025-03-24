package practice.oop.part1;

import org.junit.Test;
import ru.sber.base.syntax.oop.part1.phone.Phone;

public class PhoneJUnitTest {

    @Test
    public void initTest() {
        Phone a = new Phone("+7911", "samsung", 1300);
        Phone b = new Phone("+7911", "iphone", 1400);
    }

    @Test
    public void methodsPhoneTest() {
        Phone a = new Phone("+7911", "samsung", 1300);

        a.receiveCall("Иван");
        a.receiveCall("Иван", "+7913");

        a.sendMessage(new Phone("+7914", "huawei", 1500),
                new Phone("+7915", "motorola", 1000));
    }

    @Test
    public void toStringTest() {
        System.out.println(new Phone("+7911", "samsung", 1300));
        System.out.println(new Phone("+7912", "iphone", 1400));
    }
}
