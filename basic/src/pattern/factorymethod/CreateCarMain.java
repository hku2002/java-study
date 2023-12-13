package pattern.factorymethod;

import pattern.factorymethod.factory.CarFactory;
import pattern.factorymethod.factory.HyundaiCarFactory;
import pattern.factorymethod.factory.TeslaFactory;
import pattern.factorymethod.product.Car;

public class CreateCarMain {

    public static void main(String[] args) {
        CarFactory carFactory = new HyundaiCarFactory();
        Car car1 = carFactory.createCar("제네시스", "블랙");

        System.out.println(car1.getName());
        System.out.println(car1.getColor());

        CarFactory teslaFactory = new TeslaFactory();
        Car car2 = teslaFactory.createCar("Model1", "Blue");

        System.out.println(car2.getName());
        System.out.println(car2.getColor());

    }

}
