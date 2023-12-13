package pattern.factorymethod.factory;

import pattern.factorymethod.product.Car;
import pattern.factorymethod.product.HyundaiCar;

public class HyundaiCarFactory extends CarFactory {
    @Override
    public Car getCarInstance() {
        return new HyundaiCar();
    }

    @Override
    public void setCarName(Car car, String name) {
        car.setName(name);
    }

    @Override
    public void setCarColor(Car car, String color) {
        car.setColor(color);
    }
}
