package ru.sber.base.syntax.practice_01;

import java.util.Random;
import java.util.Scanner;

public class Task9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char puzzled = (char) (new Random().nextInt('Z' - 'A') + 'A');
        while (true) {
            System.out.print("Введите букву: ");
            char character = scanner.next().charAt(0);

            if (character < 'A' || character > 'Z') {
                System.out.println("Введен недопустимый символ");
            } else if (character == puzzled) {
                System.out.println("Верно!");
                break;
            } else {
                System.out.println(puzzled < character ?
                        "Ищи букву, которая перед ней в алфавите" :
                        "Ищи букву, которая после нее в алфавите");
            }
        }
    }
}
