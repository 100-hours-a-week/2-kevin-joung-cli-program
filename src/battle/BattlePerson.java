package battle;

import java.util.concurrent.ThreadLocalRandom;

public class BattlePerson extends Thread {
    public String name;
    public int hp;
    private BattlePerson enemy;

    BattlePerson(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    public void setEnemy(BattlePerson enemy) {
        this.enemy = enemy;
    }

    @Override
    public void run() {
        if (enemy == null) {
            System.out.println("Error: 상대가 지정이 안됐습니다.");
            return;
        }

        while (this.hp > 0 && enemy.hp > 0) {
            int damage = attack();
            if (damage > 0) {
                enemy.receiveDamage(damage);
            }
        }
    }

    private int attack() {
        try {
            // Random은 멀티 스레드 환경에서 같은 인스턴스를 공유하여 씀.
            // -> 동시에 요청이 들어오면 경합 발생 가능
            // ThreadLocalRandom로 쓰레드마다 생성된 Random 인스턴스에서 난수를 가져옴
            // 1초 ~ 5초의 쿨타임
            int coolTime = ThreadLocalRandom.current().nextInt(1000, 5000);
            Thread.sleep(coolTime);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // 스레드가 잠든 순간에 내 체력이 0 미만일수도
        if (this.hp <= 0 || enemy.hp <= 0) {
            return 0;
        }

        // 10 ~ 30의 공격을 리턴
        int damage = ThreadLocalRandom.current().nextInt(10, 30);
        if (damage >= 20) {
            System.out.println(name + "의 치명적인 공격!");
        } else {
            System.out.println(name + "의 공격!");
        }

        return damage;
    }

    private void receiveDamage(int damage) {
        this.hp -= damage;
        if (this.hp <= 0) {
            System.out.println(name + "은 " + damage + "데미지의 공격을 받았다! 남은 hp가 없다...");
        } else {
            System.out.println(name + "은 " + damage + "데미지의 공격을 받았다! 남은 체력: " + this.hp);
        }
        System.out.println("==============================");
    }
}
