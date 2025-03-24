package ru.sber.base.syntax.oop.part1.phone;

public class Main {
    public static void main(String[] args) {
        // инициализация
        Phone a = new Phone("+79115245784", "samsung", 1200);

        // Вывод информации о телефоне
        System.out.println(a);

        // Принять вызов
        a.receiveCall("Иван");
        a.receiveCall("Иван", "+79114824574");

        // Send Message
        a.sendMessage(new Phone("+79114824574", "iphone", 1300),
                new Phone("+79114812457", "samsung", 1400));
    }
}
