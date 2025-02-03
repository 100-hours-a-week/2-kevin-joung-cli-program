package component;

import java.util.List;

public class Mainboard extends Component{
    String socketType;
    String chipset;
    int maxRamSlots;

    public Mainboard(
            String name,
            int price,
            int powerConsumption,
            String brand,
            String socketType,
            String chipset,
            int maxRamSlots
    ) {
        super(name, price, powerConsumption, brand);
        this.socketType = socketType;
        this.chipset = chipset;
        this.maxRamSlots = maxRamSlots;
    }

    @Override
    public String getInfo() {
        return String.format(
                "(%s) %s: %s/%s/%d RAM 슬롯 -> %,d원",
                brand, name, socketType, chipset, maxRamSlots, price
        );
    }

    public boolean isCompatibleWith(CPU cpu) {
        return this.socketType.equals(cpu.socketType);
    }
}
