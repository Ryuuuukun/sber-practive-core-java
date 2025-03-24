package ru.sber.base.syntax.oop.part1.matrix;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class Matrix {
    private final double[][] source;

    private final int rows;
    private final int cols;

    public Matrix(int rows, int cols) {
        this.source = new double[rows][cols];

        this.rows = rows;
        this.cols = cols;
    }

    public Matrix(@NotNull final Matrix other) {
        this.source = Arrays.stream(other.source)
                .map(double[]::clone).toArray(double[][]::new);

        this.rows = other.getRows();
        this.cols = other.getCols();
    }

    @NotNull
    public static Matrix from(int rows, int cols, @NotNull final String token) {
        Matrix tmp = new Matrix(rows, cols);

        int i = 0;
        int j = 0;
        StringBuilder builder = new StringBuilder();
        for (int k = 0; k < token.length(); ++k) {
            if (Character.isDigit(token.charAt(k)) || token.charAt(k) == '.' ||
                token.charAt(k) == '+' || token.charAt(k) == '-') {
                builder.append(token.charAt(k));
            } else if (!builder.isEmpty()) {
                tmp.setValue(i, j++, Double.parseDouble(builder.toString()));

                i += j / cols;
                j %= cols;
                builder.setLength(0);
            }
        }

        if (!builder.isEmpty()) {
            tmp.setValue(i, j, Double.parseDouble(builder.toString()));
        }

        return tmp;
    }

    @Contract("_ -> this")
    public Matrix add(double value) {
        return this.transform((a) -> a + value);
    }

    @Contract("_ -> this")
    public Matrix sub(double value) {
        return this.transform((a) -> a - value);
    }

    @Contract("_ -> this")
    public Matrix mul(double value) {
        return this.transform((a) -> a * value);
    }

    @Contract("_ -> new")
    public Matrix add(@NotNull final Matrix other) {
        return new Matrix(this)
                .merge(other, Double::sum);
    }

    @Contract("_ -> new")
    public Matrix sub(@NotNull final Matrix other) {
        return new Matrix(this)
                .merge(other, (a, b) -> a - b);
    }

    @Contract("_ -> new")
    public Matrix mul(@NotNull final Matrix other) {
        Matrix tmp = new Matrix(this.rows, other.getCols());

        for (int i = 0; i < tmp.getRows(); ++i) {
            for (int j = 0; j < tmp.getCols(); ++j) {
                double sum = 0.0;

                for (int k = 0; k < this.cols; ++k) {
                    sum += this.source[i][k] * other.getValue(k, j);
                }

                tmp.setValue(i, j, sum);
            }
        }

        return tmp;
    }

    @Contract("_ -> this")
    public Matrix transform(@NotNull UnaryOperator<Double> operator) {
        for (int i = 0; i < this.rows; ++i) {
            for (int j = 0; j < this.cols; ++j) {
                this.source[i][j] = operator.apply(this.source[i][j]);
            }
        }

        return this;
    }

    @Contract("_, _ -> this")
    public Matrix merge(@NotNull final Matrix other, @NotNull BinaryOperator<Double> operator) {
        for (int i = 0; i < this.rows; ++i) {
            for (int j = 0; j < this.cols; ++j) {
                this.source[i][j] = operator.apply(this.source[i][j], other.getValue(i, j));
            }
        }

        return this;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (var row : this.source) {
            for (var element : row) {
                builder.append(element).append(" ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    public double getValue(int i, int j) {
        return this.source[i][j];
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public void setValue(int i, int j, double value) {
        this.source[i][j] = value;
    }
}
