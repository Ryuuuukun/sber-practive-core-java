package ru.sber.base.syntax.practice_01;

import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите a = ");
        double a = scanner.nextDouble();
        System.out.print("Введите b = ");
        double b = scanner.nextDouble();
        System.out.print("Введите c = ");
        double c = scanner.nextDouble();

        double disc = b * b - 4 * a * c;
        if (disc < 0) {
            System.out.println("Уравнение не имеет решения в действительных числах.");
        } else if (disc == 0) {
            System.out.println("Корень уравнения x = " + (-b + Math.sqrt(disc)) / 2.0 / a);
        } else {
            System.out.println("Корни уравнения x_1 = " + (-b - Math.sqrt(disc)) / 2.0 / a + " x_2 = " +
                    (-b + Math.sqrt(disc)) / 2.0 / a);
        }
    }
}
