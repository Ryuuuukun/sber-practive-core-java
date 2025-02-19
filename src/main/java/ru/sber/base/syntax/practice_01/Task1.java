package ru.sber.base.syntax.practice_01;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        System.out.print("Введите ваше имя: ");
        String name = new Scanner(System.in).next();

        System.out.println("Hello, " + name + "!");
    }
}
