package com.dealer.car;

/**
 * Created by employee on 5/25/15.
 */
public class ManagerBrand implements Comparable{
    private Manager manager;
    private Brand brand;

    @Override
    public int compareTo(Object o) {
        ManagerBrand managerBrand = ((ManagerBrand) o);
        int result = 0;

        result += manager.compareTo(managerBrand.getManager()) == 0 ? 0 : 1;
        result += brand == managerBrand.getBrand() ? 0 : 1;

        return result;
    }

    public Manager getManager() {
        return manager;
    }

    public Brand getBrand() {
        return brand;
    }
}
