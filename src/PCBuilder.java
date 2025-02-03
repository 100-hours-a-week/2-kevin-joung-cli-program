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
        return (CPU) components.getFirst();
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
