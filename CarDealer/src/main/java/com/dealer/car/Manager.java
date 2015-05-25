package com.dealer.car;

import java.util.Comparator;

/**
 * Created by Yaroslav on 23.05.2015.
 */
public class Manager implements Comparable {
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

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public int compareTo(Object o) {
        Manager otherManager = ((Manager) o);
        int result = 0;

        result += (salaryForOneSale == otherManager.getSalaryForOneSale()) ? 0 : 1;
        result += (firstName.compareTo(otherManager.getFirstName()) == 0) ? 0 : 1;
        result += (lastName.compareTo(otherManager.getLastName()) == 0) ? 0 : 1;

        return result;
    }
}
