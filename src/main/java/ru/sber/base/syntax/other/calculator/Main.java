package ru.sber.base.syntax.other.calculator;

public class Main {
    public static void main(String[] args) {
        // Вычисление выражения
        System.out.println(Calculator.evaluate("2.5 * 2.5 + 1.5"));

        // Записать выражение со скобками
        System.out.println(Calculator.canonical("(2.5 + 2.5) * 45 + 78 * 78"));
    }
}
