package component.storage;

import component.Component;

public class Storage extends Component {
    int memory;

    public Storage(String name, int price, int powerConsumption, String brand, int memory) {
        super(name, price, powerConsumption, brand);
        this.memory = memory;
    }

    @Override
    public String getInfo() {
        return "";
    }
}
