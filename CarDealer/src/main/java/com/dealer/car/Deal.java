package com.dealer.car;

/**
 * Created by Yaroslav on 23.05.2015.
 */
public class Deal {
    private Sale sale;
    private Manager manager;
    private Client client;

    public Deal(Car car, Manager manager, Client client) {
        this.manager = manager;
        this.client = client;
        sale = new Sale(car, this);
    }

    public Sale getSale() {
        return sale;
    }

    public Manager getManager() {
        return manager;
    }
}
