package com.dealer.car;

/**
 * Created by Yaroslav on 23.05.2015.
 */
public class Manager {
    private String firstName;
    private String lastName;
    private Double salaryForOneSale;

    public Double getSalaryForOneSale() {
        return salaryForOneSale;
    }

    public Manager(String firstName, String lastName, Double salaryForOneSale) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salaryForOneSale = salaryForOneSale;
    }
}
