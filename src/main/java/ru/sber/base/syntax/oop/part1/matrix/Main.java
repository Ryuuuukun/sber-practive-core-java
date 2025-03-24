package ru.sber.base.syntax.oop.part1.matrix;

public class Main {
    public static void main(String[] args) {
        // инициализация
        Matrix a = Matrix.from(2, 2, "1.0 0.0 1.2 1.3");
        Matrix b = new Matrix(2, 2);
        Matrix c = new Matrix(a);

        // операции с числами
        a.add(1.2);
        a.sub(2.0);
        a.mul(7.3);

        // операции с матрицами
        Matrix resultAdd = a.add(b);
        Matrix resultSub = a.sub(c);
        Matrix resultMul = a.mul(b);

        // вывод информации о матрице
        System.out.println("матрица a:\n" + a);
        System.out.println("матрица b:\n" + b);
    }
}
