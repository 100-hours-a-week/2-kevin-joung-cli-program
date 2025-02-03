import component.CPU;
import component.Component;
import component.Mainboard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    String errorMsg = "올바른 번호를 입력하세요!";
    Scanner sc = new Scanner(System.in);
    PCBuilder pcBuilder = new PCBuilder();
    Shop shop = new Shop();

    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }

    private void start() {
        System.out.println("============== Desktop ==============");
        System.out.println("=      나만의 조립 컴퓨터를 만들어봐요!     =");
        System.out.println("=====================================");

        sellComponent("CPU", shop.cpuList, null);
        sellComponent("Mainboard", shop.mainboardList, mainboard -> {
            CPU currentCPU = pcBuilder.getCurrentCPU();
            if (currentCPU == null) {
                System.out.println("CPU가 선택되지 않았습니다.");
                return false;
            }
            if (!mainboard.isCompatibleWith(currentCPU)) {
                System.out.println("이 메인보드는 선택하신 CPU와 호환되지 않습니다. 다시 선택해주세요.");
                System.out.println("호환되는 소켓: " + currentCPU.socketType);
                return false;
            }
            return true;
        });
        sellComponent("RAM", shop.ramList, null);
        sellComponent("GPU", shop.gpuList, null);
        sellComponent("Storage", shop.storageList, null);
        sellComponent("PowerSupply", shop.powerSupplyList, powerSupply -> {
            int totalWattage = pcBuilder.calcTotalWattage();
            if (totalWattage > powerSupply.wattage) {
                System.out.println("파워 요구량이 부족합니다! 다시 선택해주세요.");
                System.out.printf("현재 PC의 전력 요구량: %d, 선택하신 파워의 전력: %d\n", totalWattage, powerSupply.wattage);
                return false;
            }
            return true;
        });
        System.out.println(pcBuilder.calcTotalWattage());
        payForDesktop();
    }

    private <T extends Component> void sellComponent(
            String title,
            List<T> componentList,
            Predicate<T> predicate
    ) {
        System.out.println("=====================================");
        System.out.printf("=     원하는 %s의 번호를 입력해주세요!    =%n", title);
        System.out.println("=      0을 눌러 프로그램을 종료합니다.     =");
        System.out.println("=====================================");
        for (int i=0; i<componentList.size(); i++) {
            System.out.println(i+1 + ". " + componentList.get(i).getInfo());
        }

        while (true) {
            try {
                System.out.print("번호를 입력하세요: ");
                int number = sc.nextInt();
                if (number == 0) {
                    System.exit(0);
                } else if (number > 0 && number <= componentList.size()) {
                    T component = componentList.get(number - 1);
                    if (predicate == null || predicate.test(component)) {
                        pcBuilder.addComponent(componentList.get(number-1));
                        break;
                    }
                } else {
                    System.out.println(errorMsg);
                }
            } catch (NumberFormatException e) {
                System.out.println(errorMsg);
            }
        }
    }

    private void payForDesktop() {
        System.out.println("========================================================");
        System.out.println("                          영수증                         ");
        for (Component component : pcBuilder.components) {
            System.out.println(component.getInfo());
        }
        System.out.println("========================================================");

        System.out.println("=====================================");
        System.out.printf("=        총 합:  %,d원         =\n", pcBuilder.calcTotalPrice() );
        System.out.println("=        이용해 주셔서 감사합니다.        =");
        System.out.println("=====================================");
    }
}