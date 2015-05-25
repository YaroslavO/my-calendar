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

        Map<ManagerBrand, Integer> managerBrandMap = getManagerBrandCountMap(manager, managerDealsList);

        Set<ManagerBrand> managerBrandKeySet = managerBrandMap.keySet();
        ManagerBrand bestManagerBrandOfCount = null;
        ManagerBrand bestManagerBrandOfPrice = null;
        int count;
        int maxCount = 0;
        double price = 0;
        double maxPrice = 0;

        for (ManagerBrand mb: managerBrandKeySet) {
            count = managerBrandMap.get(mb);
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

        try {
            bestManagerBrandOfCount.setCount(maxCount);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        return  (bestManagerBrandOfCount.getPriceOfDeals() >= bestManagerBrandOfPrice.getPriceOfDeals())
                ? bestManagerBrandOfCount
                : bestManagerBrandOfPrice;
    }

    private Map<ManagerBrand, Integer> getManagerBrandCountMap(Manager manager, List<Deal> deals) {
        Map<ManagerBrand, Integer> managerBrandMap = new HashMap<>();
        ManagerBrand managerBrand;
        int count;
        double price;
        double profit;

        for (Deal deal: deals) {
            managerBrand = new ManagerBrand(manager, deal.getSale().getCarForSale().getBrand());
            price = deal.getSale().getCostOfSale();
            if (managerBrandMap.containsKey(managerBrand)) {
                count = managerBrandMap.get(managerBrand);
                profit = managerBrand.getPriceOfDeals();
                profit += price;
                managerBrand.setPriceOfDeals(profit);
                managerBrandMap.put(managerBrand, count);
            } else {
                managerBrand.setPriceOfDeals(price);
                managerBrandMap.put(managerBrand, 1);
            }
        }

        return managerBrandMap;
    }
}
