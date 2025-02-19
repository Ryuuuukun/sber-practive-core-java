package ru.sber.base.syntax.practice_01;

import java.util.Arrays;

public class Task8 {
    public static void main(String[] args) {
        int[] array = new int[30];

        for (int i = 0; i < array.length; ++i) {
            array[i] = (int) (Math.random() * 1000);
        }

        System.out.println("Массив до сортировки " + Arrays.toString(array));

        for (int i = array.length - 1; i >= 0; --i) {
            for (int j = 0; j < i; ++j) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }

        System.out.println("Отсортированный массив " + Arrays.toString(array));
    }
}
