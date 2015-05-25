package com.dealer.car;

/**
 * Created by employee on 5/25/15.
 */
public class ConsoleCarDealerRenderer implements Renderer {
    public static final String QUOTE = "\"";
    public static final String COLOR_BLACK = "\u001B[30m";
    public static final String COLOR_GREEN = "\u001B[32m";
    public static final String COLOR_RED = "\u001B[31m";
    public static final String COLOR_YELLOW = "\u001B[33m";

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
            result += COLOR_BLACK + "Best brand " + QUOTE;
            result += COLOR_YELLOW + managerBrand.getBrand().getName() + COLOR_BLACK + QUOTE;
            result += " for manager " + QUOTE + COLOR_GREEN + manager.getFirstName() + " ";
            result += manager.getLastName() + COLOR_BLACK + QUOTE;
            result += " count sales " + COLOR_RED + managerBrand.getCount() + COLOR_BLACK;
            result += " sum price " + COLOR_RED + managerBrand.getPriceOfDeals() + COLOR_BLACK + "\n";
        }

        return result;
    }
}
