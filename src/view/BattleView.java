package view;

import dto.BattleResultDTO;

public class BattleView {
    public void printIntro(String name1, String name2){
        System.out.println("======= 싸움 이벤트 발생 =======");
        System.out.println(name1 + "가 " + name2 + "에게 시비를 걸어온다...");
        System.out.println(name1 + ": 너가 이기면 10% 할인을, 내가 이기면 10%의 가격 인상을 부여한다!");
    }

    public void printBattleResult(BattleResultDTO battleResult) {
        if (battleResult.getWinner().isCustomer) {
            System.out.println(battleResult.getWinner().name + "의 승리로 가격이 10% 인하됐습니다.");
            System.out.printf("할인 후 가격: %,d원\n", battleResult.getComponent().price);
        } else {
            System.out.println(battleResult.getWinner().getName() + "의 승리로 가격이 10% 인상됐습니다.");
            System.out.printf("인상 후 가격: %,d원\n", battleResult.getComponent().price);
        }
    }
}