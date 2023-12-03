package sample04;

public class Driver {

    private final Car car;

    public Driver(Car car) {
        this.car = car;
    }

    public void drive() {
        car.onEngine();
        car.pushAccelerate();
        car.pushAccelerate();
        car.pushBreak();
        car.pushBreak();
        car.offEngine();
    }

}
