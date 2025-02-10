package controller;

import model.component.CPU;
import model.component.Component;
import model.component.Mainboard;
import model.component.PowerSupply;
import service.BattleService;
import service.ShopService;
import view.ShopView;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.function.Predicate;

public class ShopController {
    private ShopView shopView = new ShopView();
    private ShopService shopService = new ShopService();
    private BattleService battleService = new BattleService();

    // 선택한 컴포넌트들 저장
    private ArrayList<Component> components = new ArrayList<>();

    public void start() {
        shopView.printIntro();
        selectComponent("CPU", shopService.getCPUList(), null);
        selectComponent("Mainboard", shopService.getMainboardList(), this::checkMainboard);
        selectComponent("RAM", shopService.getRAMList(), null);
        selectComponent("GPU", shopService.getGPUList(), null);

        // 싸움이벤트 발생
        Component selectedComponent = battleService.startBattle(components.removeLast());
        components.add(selectedComponent);

        selectComponent("Storage", shopService.getStorageList(), null);
        selectComponent("PowerSupply", shopService.getPowerSupplyList(), this::checkPowerSupply);

        shopView.printBill(components, shopService.calcTotalPrice(components));
    }

    private <T extends Component> void selectComponent(
            String title,
            List<T> componentList,
            Predicate<T> predicate
    ) {
        shopView.printMenu(title, componentList);

        // 유저가 적절한 번호를 입력할 떄까지 반복
        while (true) {
            try {
                int selectNumber = shopView.getItemSelection();
                // 0을 누르면 프로그램 종료
                if (selectNumber == 0) {
                    System.exit(0);
                } else if (selectNumber > 0 && selectNumber <= componentList.size()) {
                    T component = componentList.get(selectNumber - 1);
                    // 조건이 없거나, 조건이 있는데 충족한다면 장바구니에 담기
                    if (predicate == null || predicate.test(component)) {
                        this.components.add(component);
                        shopView.printAfterAddingComponent(component.name);
                        break;
                    }
                } else {
                    shopView.printWrongNumberErrorMessage();
                }
            } catch (InputMismatchException e) {
                shopView.removeScannerBuffer();
                shopView.printWrongNumberErrorMessage();
            }
        }
    }

    // 현재 리스트의 CPU 가져오기
    private CPU getCurrentCPU() {
        for (Component component : components) {
            if (component instanceof CPU) {
                return (CPU) component;
            }
        }
        return null;
    }

    // CPU와 메인보드가 호환되는지
    private boolean checkMainboard(Mainboard mainboard) {
        CPU currentCPU = getCurrentCPU();

        if (currentCPU == null) {
            shopView.printNoCPUSelectionErrorMessage();
            return false;
        }

        if (!mainboard.isCompatibleWith(currentCPU)) {
            shopView.printMainboardIsntCompatibleWithCPU(currentCPU.socketType);
            return false;
        }

        return true;
    }

    // 파워 전력요구량이 충족하는지
    private boolean checkPowerSupply(PowerSupply powerSupply) {
        int totalWattage = shopService.calcTotalWattage(components);
        if (totalWattage > powerSupply.wattage) {
            shopView.printLackWattagePowerSupplyErrorMessage(totalWattage, powerSupply.wattage);
            return false;
        }
        return true;
    }
}
