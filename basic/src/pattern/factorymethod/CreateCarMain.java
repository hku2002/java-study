package pattern.factorymethod;

import pattern.factorymethod.factory.CarFactory;
import pattern.factorymethod.factory.HyundaiCarFactory;
import pattern.factorymethod.product.Car;

public class CreateCarMain {

    public static void main(String[] args) {
        CarFactory carFactory = new HyundaiCarFactory();
        Car car = carFactory.createCar("제네시스", "블랙");

        System.out.println(car.getName());
        System.out.println(car.getColor());

    }

}
