package com.dealer.car;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by employee on 5/25/15.
 */
public class ConsoleCarDealerRenderer implements Renderer {
    private CarDealer carDealer;

    ConsoleCarDealerRenderer (CarDealer carDealer) {
        this.carDealer = carDealer;
    }

    @Override
    public String render() {
        String result = "";

        Calculator calculator = new Calculator(carDealer);
        for (Manager manager: carDealer.getManagers()) {
            ManagerBrand managerBrand = calculator.getBestBrandForManager(manager);
            result += "Best brand = \"";
            result += managerBrand.getBrand().getName() + "\" ";
            result += "for manager first name = " + "\"" + manager.getFirstName();
            result += " last name = " + "\"" + manager.getLastName();
            result += " count sales " + managerBrand.getCount();
            result += " sum price " + managerBrand.getPriceOfDeals() + "\n";
        }

        return result;
    }
}
