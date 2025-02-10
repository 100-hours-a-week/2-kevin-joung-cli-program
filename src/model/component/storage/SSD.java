package model.component.storage;

public class SSD extends Storage {
    String socketType;
    String formFactor;

    public SSD(String name, int price, int powerConsumption, String brand, int memory, String socketType, String formfactor) {
        super(name, price, powerConsumption, brand, memory);
        this.socketType = socketType;
        this.formFactor = formfactor;
    }

    @Override
    public String getInfo() {
        return String.format(
                "(%s) %s: %dGB/%s/%s -> %,d원",
                brand, name, memory, socketType, formFactor, price
        );
    }
}
