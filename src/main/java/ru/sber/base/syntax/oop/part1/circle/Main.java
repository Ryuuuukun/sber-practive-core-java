package ru.sber.base.syntax.oop.part1.circle;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // инициализация
        Circle a = new Circle(1.0, Color.RED);
        Circle b = new Circle(2.0, Color.PINK);

        // вычисление площади и периметра
        System.out.println("площадь a = " + a.area() + ", площадь b = " + b.area());
        System.out.println("периметр a = " + a.perimeter() + ", периметр b = " + b.perimeter());

        // вывод информации о круге
        System.out.println(a);
        System.out.println(b);
    }
}
