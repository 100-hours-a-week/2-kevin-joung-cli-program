package component;

public class RAM extends Component {
    String type;
    int memory;
    int clockSpeed;

    public RAM(
            String name,
            int price,
            int powerConsumption,
            String brand,
            String type,
            int memory,
            int clockSpeed
    ) {
        super(name, price, powerConsumption, brand);
        this.type = type;
        this.memory = memory;
        this.clockSpeed = clockSpeed;
    }

    @Override
    public String getInfo() {
        return String.format("(%s) %s: %s/%dGB/%dMHz -> %,d원",
                brand, name, type, memory, clockSpeed, price);
    }
}
