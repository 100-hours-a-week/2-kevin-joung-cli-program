package view;

import constants.ErrorMessage;
import model.component.Component;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ShopView {
    Scanner sc = new Scanner(System.in);

    // 인트로 출력
    public void printIntro() {
        System.out.println("============== Desktop ==============");
        System.out.println("=      나만의 조립 컴퓨터를 만들어봐요!     =");
        System.out.println("=====================================");
    }

    // 각 메뉴 항목 출력
    public <T extends Component> void printMenu(
            String title,
            List<T> componentList
    ) {
        System.out.println("=====================================");
        System.out.printf("  - 원하는 %s의 번호를 입력해주세요!    %n", title);
        System.out.println("  - 0을 눌러 프로그램을 종료합니다.     ");
        System.out.println("=====================================");

        for (int i = 0; i < componentList.size(); i++) {
            System.out.println(i + 1 + ". " + componentList.get(i).getInfo());
        }
    }

    // 유저가 아이템의 번호를 입력
    public int getItemSelection() throws InputMismatchException {
        System.out.print("번호를 입력하세요: ");
        return sc.nextInt();
    }

    // 아이템을 추가한 후 출력
    public void printAfterAddingComponent(String name) {
        System.out.println(name + "을 장바구니에 담았습니다.");
    }

    public void removeScannerBuffer() {
        sc.nextLine();
    }

    // CPU와 호환되지 않는 메인보드를 선택했을 때 출력
    public void printMainboardIsntCompatibleWithCPU(String cpuSocketType) {
        System.out.println("이 메인보드는 선택하신 CPU와 호환되지 않습니다. 다시 선택해주세요.");
        System.out.println("호환되는 소켓: " + cpuSocketType);
    }

    // 올바르지 않은 번호를 입력했을 때 출력
    public void printWrongNumberErrorMessage() {
        System.out.println(ErrorMessage.WRONG_NUMBER.getMessage());
    }

    // 부족한 전력의 파워를 선택했을 때 출력
    public void printLackWattagePowerSupplyErrorMessage(int totalWattage, int powerSupplyWattage) {
        System.out.println(ErrorMessage.LACK_WATTAGE.getMessage());
        System.out.printf("현재 PC의 전력 요구량: %d, 선택하신 파워의 전력: %d\n", totalWattage, powerSupplyWattage);
    }

    // CPU가 선택되지 않았을 때 출력
    public void printNoCPUSelectionErrorMessage() {
        System.out.println("CPU가 선택되지 않았습니다.");
    }

    // 영수증 출력
    public void printBill(List<Component> components, int totalPrice) {
        System.out.println("========================================================================");
        System.out.println("                                  영수증                                 ");
        for (Component component : components) {
            System.out.println(component.getInfo());
        }
        System.out.println("========================================================================");

        System.out.println("=====================================");
        System.out.printf("=        총 합:  %,d원         =\n", totalPrice );
        System.out.println("=        이용해 주셔서 감사합니다.        =");
        System.out.println("=====================================");
    }
}
