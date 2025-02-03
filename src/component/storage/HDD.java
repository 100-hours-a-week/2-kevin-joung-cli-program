package component.storage;

public class HDD extends Storage {
    int RPM;
    double size;

    public HDD(String name, int price, int powerConsumption, String brand, int memory, int rpm, double size) {
        super(name, price, powerConsumption, brand, memory);
        this.RPM = rpm;
        this.size = size;
    }

    @Override
    public String getInfo() {
        return String.format(
                "(%s) %s: %dGB/%.1f인치/%d RPM -> %,d원",
                brand, name, memory, size, RPM, price
        );
    }
}
