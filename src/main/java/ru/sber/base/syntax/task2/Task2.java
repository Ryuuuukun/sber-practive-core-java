package ru.sber.base.syntax.task2;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество чисел: ");
        int count = scanner.nextInt();

        if (count <= 0 || count > 500) {
            System.out.println("Введено недопустимое число " + count + ". Допустимый диапазон значений: 1 - 500");
        } else {
            for (int i = 1; i <= count; ++i) {
                System.out.print(i * 7 + " ");
            }
        }
    }
}
