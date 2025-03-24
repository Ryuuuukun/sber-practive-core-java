package ru.sber.base.syntax.oop.part1.pizza;

public class Main {
    public static void main(String[] args) {
        // инициализация
        PizzaOrder order = new PizzaOrder("Аль-Капчоне", "Ярославская", PizzaSize.BIG, false);

        // принять заказ
        order.order();

        // повторное принятие заказа
        order.order();

        // вывод информации о заказе
        System.out.println(order);

        // отмена заказа
        order.cancel();

        // повторная отмена заказа
        order.cancel();
    }
}
