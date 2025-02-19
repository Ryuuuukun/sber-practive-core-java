package ru.sber.base.syntax.practicex01;

public class Task3 {
    public static void main(String[] args) {
        final long width = 7;
        final long height = 5;

        for (long i = 0; i < height; ++i) {
            for (long j = 0; j < width - i % 2; ++j) {
                System.out.print((i % 2 == 0 ? ("* ") : (" *")));
            }
            System.out.println();
        }
    }
}
