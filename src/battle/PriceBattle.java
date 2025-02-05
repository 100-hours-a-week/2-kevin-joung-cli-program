package battle;

import component.Component;

public class PriceBattle {
    BattlePerson seller = new BattlePerson("용팔이", 100);
    BattlePerson customer = new BattlePerson("케빈", 100);

    public Component startBattle(Component selectedComponent) {
        System.out.println("======= 싸움 이벤트 발생 =======");
        System.out.println(seller.name + "가 " + customer.name + "에게 시비를 걸어온다...");
        System.out.println(seller.name + ": 너가 이기면 10% 할인을, 내가 이기면 10%의 가격 인상을 부여한다!");

        seller.setEnemy(customer);
        customer.setEnemy(seller);

        seller.start();
        customer.start();

        try {
            seller.join();
            customer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (seller.hp > 0) {
            System.out.println(seller.name + "의 승리로 가격이 10% 인상됐습니다.");
            System.out.printf("%,d원", selectedComponent.price);
            selectedComponent.price *= 1.1;
            System.out.printf(" -> %,d원\n", selectedComponent.price);
            return selectedComponent;
        } else if (customer.hp > 0) {
            System.out.println(customer.name + "의 승리로 가격이 10% 인하됐습니다.");
            System.out.printf("%,d원", selectedComponent.price);
            selectedComponent.price *= 0.9;
            System.out.printf(" -> %,d원\n", selectedComponent.price);
            return selectedComponent;
        } else {
            return selectedComponent;
        }
    }
}
