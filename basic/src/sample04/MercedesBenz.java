package sample04;

public class MercedesBenz implements Car {

    private int speed;
    private boolean isEngine;
    private static final int MAX_SPEED = 200;


    @Override
    public void onEngine() {
        if (isEngine) {
            System.out.println("시동이 이미 켜져있습니다.");
            return;
        }

        isEngine = true;
        System.out.println("시동이 켜졌습니다.");
    }

    @Override
    public void offEngine() {
        if (!isEngine) {
            System.out.println("시동이 이미 꺼져 있습니다.");
            return;
        }

        if (speed > 0) {
            System.out.println("시동을 끌 수 없습니다.");
            return;
        }

        isEngine = false;
        System.out.println("시동이 꺼졌습니다.");
    }

    @Override
    public void pushAccelerate() {
        if (!checkMaxSpeed(10)) {
            return;
        }

        speed += 10;
        System.out.println("현재 스피드: " + speed);
    }

    @Override
    public void pushBreak() {
        if (speed <= 0) {
            return;
        }

        speed -= 10;
        if (speed < 0) {
            speed = 0;
        }
        System.out.println("현재 스피드: " + speed);
    }

    private boolean checkMaxSpeed(int speed) {
        if (MAX_SPEED < (this.speed + speed)) {
            System.out.println("200이 최대 속도 입니다.");
            return false;
        }
        return true;
    }
}
