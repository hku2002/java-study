package pattern.factorymethod.factory;

import pattern.factorymethod.product.Car;

public abstract class CarFactory {

    public Car createCar(String name, String color) {
        Car car = getCarInstance();
        setCarName(car, name);
        setCarColor(car, color);
        return car;
    }

    public abstract Car getCarInstance();

    public abstract void setCarName(Car car, String name);

    public abstract void setCarColor(Car car, String color);
}
