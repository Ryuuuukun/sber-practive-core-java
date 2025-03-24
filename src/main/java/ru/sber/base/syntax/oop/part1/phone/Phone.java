package ru.sber.base.syntax.oop.part1.phone;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Phone {
    private String number;
    private String model;

    private int weight;

    public Phone(String number, String model, int weight) {
        this.number = number;
        this.model = model;
        this.weight = weight;
    }

    public Phone(String number, String model) {
        this(number, model, 0);
    }

    public Phone() {
        this(null, null, 0);
    }

    public void receiveCall(@NotNull final String name) {
        System.out.println("Звонит " + name);
    }

    public void receiveCall(@NotNull final String name, @NotNull final String number) {
        System.out.println("Звонит " + name + ", номер телефона " + number);
    }

    public void sendMessage(@NotNull Phone... phones) {
        for (var phone : phones) {
            System.out.println("Номер телефона " + phone.getNumber());
        }
    }

    public void sendMessage(@NotNull List<Phone> phones) {
        phones.forEach((phone) ->
                System.out.println("Номер телефона " + phone.getNumber()));
    }

    @Override
    public String toString() {
        return "Телефон (номер = " + this.number +
                    ", модель = " + this.model +
                    ", вес = " + this.weight + ")";
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
