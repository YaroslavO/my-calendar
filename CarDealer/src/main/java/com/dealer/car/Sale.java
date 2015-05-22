package com.dealer.car;

/**
 * Created by Yaroslav on 23.05.2015.
 */
public class Sale {
    private Car carForSale;
    private Boolean sold;
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
        result += carForSale.getBrend().getPrice();
        result += deal.getManager().getSalaryForOneSale();

        return result;
    }
}
