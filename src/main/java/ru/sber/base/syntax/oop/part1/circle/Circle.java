package ru.sber.base.syntax.oop.part1.circle;

import java.awt.*;

public class Circle {
    private final double radius;
    private final Color color;

    public Circle(double radius, Color color) {
        this.radius = radius;
        this.color = color;
    }

    public double area() {
        return Math.PI * this.radius * this.radius;
    }

    public double perimeter() {
        return 2 * Math.PI * this.radius;
    }

    @Override
    public String toString() {
        return "Круг с радиусом " + this.radius + " с цветом rgb(" +
                this.color.getRed() + ", " + this.color.getGreen() + ", " + this.color.getBlue() + ")";
    }

    public double getRadius() {
        return radius;
    }

    public Color getColor() {
        return color;
    }
}
