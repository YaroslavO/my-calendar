package com.dealer.car;

/**
 * Created by Yaroslav on 23.05.2015.
 */
public class Sale {
    private Car carForSale;
    private Deal deal;
    private Double costOfSale;

    public Sale(Car car, Deal deal) {
        this.deal = deal;
        this.carForSale = car;
        this.costOfSale = calculateCostOfSale();
    }

    private Double calculateCostOfSale() {
        Double result = 0.0;
        result += carForSale.getPrice();
        result += carForSale.getBrand().getPrice();
        result += deal.getManager().getSalaryForOneSale();

        return result;
    }

    public Car getCarForSale() {
        return carForSale;
    }

    public Double getCostOfSale() {
        return costOfSale;
    }
}
