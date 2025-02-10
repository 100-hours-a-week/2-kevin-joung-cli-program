package dto;

import model.Person;
import model.component.Component;

public class BattleResultDTO {
    private final Component component;
    private final Person winner;

    public BattleResultDTO(Component component, Person winner) {
        this.component = component;
        this.winner = winner;
    }

    public Person getWinner() {
        return winner;
    }

    public Component getComponent() {
        return component;
    }

    public void updateComponentPriceWithWinner() {
        if (winner.isCustomer) {
            component.price *= 0.9;
        } else {
            component.price *= 1.1;
        }
    }
}
