import component.CPU;
import component.Component;

import java.util.ArrayList;

public class PCBuilder {
    ArrayList<Component> components = new ArrayList<>();

    void addComponent(Component component) {
        System.out.println(component.name + "을 장바구니에 담았습니다.");
        components.add(component);
    }

    CPU getCurrentCPU() {
        for (Component component : components) {
            if (component instanceof CPU) {
                return (CPU) component;
            }
        }
        return null;
    }

    int calcTotalWattage() {
        int totalWattage = 0;
        for (Component component : components) {
            totalWattage += component.powerConsumption;
        }
        return totalWattage;
    }

    int calcTotalPrice() {
        int totalPrice = 0;
        for (Component component : components) {
            totalPrice += component.price;
        }
        return totalPrice;
    }
}
