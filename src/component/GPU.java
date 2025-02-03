package component;

public class GPU extends Component {
    int memory;

    public GPU(String name, int price, int powerConsumption, String brand, int memory) {
        super(name, price, powerConsumption, brand);
        this.memory = memory;
    }

    @Override
    public String getInfo() {
        return String.format(
                "(%s) %s: %dGB -> %,d원",
                brand, name, memory, price
        );
    }
}
