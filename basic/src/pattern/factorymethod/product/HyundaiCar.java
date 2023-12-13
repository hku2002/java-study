package pattern.factorymethod.product;

public class HyundaiCar implements Car {

    private boolean moveStatus;
    private int gearLevel;
    private boolean engineOn;
    private String name;
    private String color;

    public HyundaiCar() {
        this.moveStatus = false;
        this.gearLevel = 0;
        this.engineOn = false;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public void move() {
        this.moveStatus = true;
    }

    @Override
    public void stop() {
        this.moveStatus = false;
    }

    @Override
    public void gearUp() {
        if (this.gearLevel > 5) {
            return;
        }
        this.gearLevel += 1;
    }

    @Override
    public void gearDown() {
        if (this.gearLevel == 0) {
            return;
        }
        this.gearLevel -= 1;
    }

    @Override
    public void turnOnEngine() {
        this.engineOn = true;
    }

    @Override
    public void turnOffEngine() {
        this.engineOn = false;
    }
}
