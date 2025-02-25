package ru.sber.base.syntax.task4;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        System.out.print("Введите число: ");
        long number = new Scanner(System.in).nextInt();

        if (number <= 0) {
            System.out.println("Число должно быть больше нуля!");
        } else {
            long div = 2;
            while (number % div != 0 && div * div <= number) {
                ++div;
            }

            System.out.println(div * div > number ? "Да, число простое" : "Нет, число не простое");
        }
    }
}
