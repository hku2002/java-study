package pattern.factorymethod.product;

public interface Car {

    String getName();
    String getColor();
    void setName(String name);
    void setColor(String color);
    void move();
    void stop();
    void gearUp();
    void gearDown();
    void turnOnEngine();
    void turnOffEngine();

}
