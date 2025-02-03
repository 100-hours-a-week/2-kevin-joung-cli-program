package component;

public class CPU extends Component {
    public String socketType;
    int cores;
    int threads;
    double clockSpeed;

    public CPU(
            String name,
            int price,
            int powerConsumption,
            String brand,
            String socketType,
            int cores,
            int threads,
            double clockSpeed
    ) {
        super(name, price, powerConsumption, brand);
        this.socketType = socketType;
        this.cores = cores;
        this.threads = threads;
        this.clockSpeed = clockSpeed;
    }

    @Override
    public String getInfo() {
        return String.format(
                "(%s) %s: %s/%d코어/%d스레드/%.1fGHz -> %,d원",
                brand, name, socketType, cores, threads, clockSpeed, price
        );
    }

}
