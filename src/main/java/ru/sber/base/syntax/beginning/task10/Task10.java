package ru.sber.base.syntax.beginning.task10;

import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) {
        System.out.print("Введите ваше имя: ");
        String name = new Scanner(System.in).next();

        javax.swing.JOptionPane.showMessageDialog(null, "Привет, " + name);
    }
}
