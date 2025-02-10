package model.component;

public abstract class Component {
    public String name;
    public int price;
    public int powerConsumption;
    public String brand;

    public Component(String name, int price, int powerConsumption, String brand) {
        this.name = name;
        this.price = price;
        this.powerConsumption = powerConsumption;
        this.brand = brand;
    }

    public abstract String getInfo();
}
