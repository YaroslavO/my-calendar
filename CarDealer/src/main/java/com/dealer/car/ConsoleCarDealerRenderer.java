package com.dealer.car;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by employee on 5/25/15.
 */
public class ConsoleCarDealerRenderer implements Renderer {
    public Map<Manager, List<Deal>> managerDealsMap;

    public ConsoleCarDealerRenderer() {
        managerDealsMap = new HashMap<>();
    }

    @Override
    public String render(CarDealer carDealer) {
        String result = "";

        managerDealsMap = carDealer.getDealsManager();

        return null;
    }
}
