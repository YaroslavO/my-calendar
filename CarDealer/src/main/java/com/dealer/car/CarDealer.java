package com.dealer.car;

import java.util.*;

/**
 * Created by Yaroslav on 23.05.2015.
 */
public class CarDealer {
    private List<Car> cars;
    private List<Client> clients;
    private List<Manager> managers;
    private List<Deal> deals;

    public CarDealer() {
        cars = new ArrayList<>();
        clients = new ArrayList<>();
        managers = new ArrayList<>();
        deals = new ArrayList<>();
    }

    public void init() {
        Car car = new Car(Brand.getBrandByName("BMW"), "X6", 20000.0);
        cars.add(car);
        car = new Car(Brand.getBrandByName("Tesla"), "S", 40000.0);
        cars.add(car);
        car = new Car(Brand.getBrandByName("Audi"), "A6", 25000.0);
        cars.add(car);
        car = new Car(Brand.getBrandByName("Audi"), "A8", 30000.0);
        cars.add(car);
        car = new Car(Brand.getBrandByName("Renault"), "Logan", 40000.0);
        cars.add(car);

        Client client = new Client("Petro", "Smagluk", 40000.0);
        clients.add(client);
        client = new Client("Stepan", "Vernugora", 50000.0);
        clients.add(client);
        client = new Client("Roman", "Kulikov", 40000.0);
        clients.add(client);

        Manager manager = new Manager("Dmitro", "Antonov", 200.0);
        managers.add(manager);
        manager = new Manager("Stepan", "Fedoreds", 150.0);
        managers.add(manager);

        Deal deal;
        for (int i=1; i < cars.size(); i++) {
            deal = new Deal(cars.get(getRandomIndexFromList(cars)),
                    managers.get(getRandomIndexFromList(managers)),
                    clients.get((getRandomIndexFromList(clients))));
            deals.add(deal);
        }

    }

    public Integer getRandomIndexFromList(List list) {
        return new Random().nextInt(list.size());
    }

    public List<Deal> getListDealOfManager(Manager manager) {
        List<Deal> dealList = new ArrayList<>();

        for (Deal deal: deals) {
            if (deal.getManager().compareTo(manager) == 0) {
                dealList.add(deal);
            }
        }

        return dealList;
    }

    public List<Manager> getManagers() {
        return managers;
    }
}
