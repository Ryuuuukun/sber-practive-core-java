package ru.sber.base.syntax.roman;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static final Map<Integer, List<String>> ROMAN_DIGITS = Map.of(
            1, List.of("I", "X", "C"),
            2, List.of("II", "XX", "CC"),
            3, List.of("III", "XXX", "CCC"),
            4, List.of("IV", "XL", "CD"),
            5, List.of("V", "L", "D"),
            6, List.of("VI", "LX", "DC"),
            7, List.of("VII", "LXX", "DCC"),
            8, List.of("VIII", "LXXX", "DCCC"),
            9, List.of("IX", "XC", "CM")
    );

    public static void main(String[] args) {
        System.out.print("Введите число: ");
        int number = new Scanner(System.in).nextInt();

        if (number < 0 || number > 100) {
            System.out.println("Число должно находится в диапазоне от 0 до 100!");
        } else {
            StringBuilder roman = new StringBuilder();

            int rank = 0;
            while (number > 0) {
                roman.insert(0, ROMAN_DIGITS.get(number % 10).get(rank));

                ++rank;
                number /= 10;
            }

            System.out.println("Числов в римской системе счисления: " + roman);
        }
    }
}
