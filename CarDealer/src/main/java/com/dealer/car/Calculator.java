package com.dealer.car;

import java.util.*;

/**
 * Created by employee on 5/25/15.
 */
public class Calculator {
    private CarDealer carDealer;

    public Calculator(CarDealer carDealer) {
        this.carDealer = carDealer;
    }

    public ManagerBrand getBestBrandForManager(Manager manager) {
        List<Deal> managerDealsList = carDealer.getListDealOfManager(manager);

        Set<ManagerBrand> managerBrandSet = getManagerBrandCountMap(manager, managerDealsList);

        ManagerBrand bestManagerBrandOfCount = null;
        ManagerBrand bestManagerBrandOfPrice = null;
        int count;
        int maxCount = 0;
        double price;
        double maxPrice = 0;

        for (ManagerBrand mb: managerBrandSet) {
            count = mb.getCount();
            price = mb.getPriceOfDeals();

            if (count > maxCount) {
                maxCount = count;
                bestManagerBrandOfCount = mb;
            }

            if (price > maxPrice) {
                maxPrice = price;
                bestManagerBrandOfPrice = mb;
            }
        }

        return  (bestManagerBrandOfCount.getPriceOfDeals() >= bestManagerBrandOfPrice.getPriceOfDeals())
                ? bestManagerBrandOfCount
                : bestManagerBrandOfPrice;
    }

    private Set<ManagerBrand> getManagerBrandCountMap(Manager manager, List<Deal> deals) {
        TreeSet<ManagerBrand> managerBrandSet = new TreeSet<>();
        ManagerBrand managerBrand;
        double price;
        double profit;

        for (Deal deal: deals) {
            managerBrand = new ManagerBrand(manager, deal.getSale().getCarForSale().getBrand());
            price = deal.getSale().getCostOfSale();
            if (managerBrandSet.contains(managerBrand)) {
                for (ManagerBrand mb: managerBrandSet) {
                    if (mb.compareTo(managerBrand) == 0) {
                        managerBrand = mb;
                        break;
                    }
                }
                managerBrand.setCount(managerBrand.getCount() + 1);
                profit = managerBrand.getPriceOfDeals();
                profit += price;
                managerBrand.setPriceOfDeals(profit);
                managerBrandSet.add(managerBrand);
            } else {
                managerBrand.setPriceOfDeals(price);
                managerBrandSet.add(managerBrand);
            }
        }

        return managerBrandSet;
    }
}
