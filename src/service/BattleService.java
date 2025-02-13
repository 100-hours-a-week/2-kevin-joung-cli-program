package service;

import dto.BattleResultDTO;
import model.Person;
import model.component.Component;

public class BattleService {
    Person seller;
    Person customer;

    public BattleService(Person seller, Person customer) {
        this.seller = seller;
        this.customer = customer;
    }

    public BattleResultDTO startBattle(Component selectedComponent) {
        seller.setEnemy(customer);
        customer.setEnemy(seller);

        seller.start();
        customer.start();

        try {
            seller.join();
            customer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        BattleResultDTO battleResult;
        if (seller.hp > 0) {
            Component component = updateComponentPriceWithWinner(selectedComponent, seller);
            battleResult = new BattleResultDTO(component, seller);
        } else {
            Component component = updateComponentPriceWithWinner(selectedComponent, customer);
            battleResult = new BattleResultDTO(component, customer);
        }

        return battleResult;
    }

    private Component updateComponentPriceWithWinner(Component component, Person winner) {
        if (winner.isCustomer) {
            component.price *= 0.9;
        } else {
            component.price *= 1.1;
        }

        return component;
    }
}
