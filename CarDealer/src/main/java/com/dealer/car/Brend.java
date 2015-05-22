package com.dealer.car;

/**
 * Created by Yaroslav on 23.05.2015.
 */
public enum Brend {
    BMW("BMW", 100.0),
    TESLA("Tesla", 100.0),
    AUDI("Audi", 70.0),
    FORD("Ford", 80.0),
    RENAULT("Renault", 60.0);

    private String name;
    private Double price;

    Brend() {
    }

    Brend(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public static Brend getBrendByName(String name) {
        for (Brend brend: Brend.values()) {
            if (brend.getName().compareTo(name) != 0) {
                continue;
            }
            return brend;
        }

        return null;
    }
}
