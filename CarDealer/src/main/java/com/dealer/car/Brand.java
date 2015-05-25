package com.dealer.car;

/**
 * Created by Yaroslav on 23.05.2015.
 */
public enum Brand {
    BMW("BMW", 100.0),
    TESLA("Tesla", 100.0),
    AUDI("Audi", 70.0),
    FORD("Ford", 80.0),
    RENAULT("Renault", 60.0);

    private String name;
    private Double price;

    Brand() {
    }

    Brand(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public static Brand getBrandByName(String name) {
        for (Brand brand : Brand.values()) {
            if (brand.getName().compareTo(name) != 0) {
                continue;
            }
            return brand;
        }

        return null;
    }
}
