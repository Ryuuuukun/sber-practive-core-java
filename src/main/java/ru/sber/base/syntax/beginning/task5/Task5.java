package ru.sber.base.syntax.beginning.task5;

import java.math.BigInteger;
import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        System.out.print("Введите кол-во чисел: ");
        int n = new Scanner(System.in).nextInt();

        if (n >= 2 && n <= 100) {
            BigInteger a = new BigInteger("0");
            BigInteger b = new BigInteger("1");
            BigInteger c;

            System.out.print("0 1 ");
            for (int i = 0; i < n - 2; ++i) {
                c = a.add(b);
                System.out.print(c + " ");
                a = b;
                b = c;
            }
        } else {
            System.out.println("Кол-во чисел должно находится в диапазоне от 2 до 100");
        }
    }
}
