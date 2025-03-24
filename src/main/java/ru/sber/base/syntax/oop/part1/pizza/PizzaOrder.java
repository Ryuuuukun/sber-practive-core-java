package ru.sber.base.syntax.oop.part1.pizza;

public class PizzaOrder {
    private String name;
    private String address;

    private PizzaSize size;

    private boolean sauce;
    private boolean active;

    public PizzaOrder(String name, String address, PizzaSize size, boolean sauce) {
        this.name = name;
        this.address = address;
        this.size = size;
        this.sauce = sauce;
    }

    public void order() {
        System.out.println(this.active ? "Заказ уже принят." : "Заказ принят. " + this + ".");
        this.active = true;
    }

    public void cancel() {
        System.out.println(this.active ? "Заказ отменен." : "Заказ не был принят.");
        this.active = false;
    }

    @Override
    public String toString() {
        return this.size + " «" + this.name + "» " +
                (this.sauce ? "с соусом" : "без соуса") +
                " на адрес " + this.address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public PizzaSize getSize() {
        return size;
    }

    public boolean isSauce() {
        return sauce;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSize(PizzaSize size) {
        this.size = size;
    }

    public void setSauce(boolean sauce) {
        this.sauce = sauce;
    }
}
