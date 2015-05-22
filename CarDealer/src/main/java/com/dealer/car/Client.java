package com.dealer.car;

/**
 * Created by Yaroslav on 23.05.2015.
 */
public class Client {
    private String firstName;
    private String lastName;
    private Double moneyOnBuyCar;

    public Client(String firstName, String lastName, Double moneyOnBuyCar) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.moneyOnBuyCar = moneyOnBuyCar;
    }

    public Double getMoneyOnBuyCar() {
        return moneyOnBuyCar;
    }
}
