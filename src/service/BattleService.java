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
            battleResult = new BattleResultDTO(selectedComponent, seller);
        } else {
            battleResult = new BattleResultDTO(selectedComponent, customer);
        }
        battleResult.updateComponentPriceWithWinner();

        return battleResult;
    }
}
