package com.dealer.car;

/**
 * Created by Yaroslav on 23.05.2015.
 */
public class Car {
    private Brend brend;
    private String model;
    private Double price;

    public Car(Brend brend, String model, Double price) {
        this.brend = brend;
        this.model = model;
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public Brend getBrend() {
        return brend;
    }
}
