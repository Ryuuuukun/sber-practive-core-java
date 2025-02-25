package ru.sber.base.syntax.task6;

import java.util.ArrayList;

public class Task6 {
    private static final int SIZE = 100;

    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>();

        float average = 0.0f;
        int max = Integer.MIN_VALUE, maxIndex = -1;
        for (int i = 0; i < SIZE; ++i) {
            array.add((int) (Math.random() * 1000));

            if (max < array.getLast()) {
                maxIndex = i;
                max = array.getLast();
            }

            average += array.getLast();
        }

        average /= SIZE;

        System.out.println("Максимальное значение = " + max + " находится в элементе под индексом " + maxIndex);
        System.out.println("Среднее значение = " + average);
    }
}
