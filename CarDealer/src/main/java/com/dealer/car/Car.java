package com.dealer.car;

/**
 * Created by Yaroslav on 23.05.2015.
 */
public class Car {
    private Brand brand;
    private String model;
    private Double price;

    public Car(Brand brand, String model, Double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public Brand getBrand() {
        return brand;
    }
}
