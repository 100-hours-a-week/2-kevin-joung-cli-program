package model.component;

public class PowerSupply extends Component {
    public int wattage;

    public PowerSupply(String name, int price, int powerConsumption, String brand, int wattage) {
        super(name, price, powerConsumption, brand);
        this.wattage = wattage;
    }

    @Override
    public String getInfo() {
        return String.format("(%s) %s: %dW -> %,d원", brand, name, wattage, price);
    }
}
