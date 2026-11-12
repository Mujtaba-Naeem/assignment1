import java.awt.*;

public abstract class Vehicle implements Movable {
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name

    private double x;
    private double y;
    private int direction;

    //Constructor
    public Vehicle(int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.currentSpeed = 0;

    }

    // Getters
    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color clr) {
        this.color = clr;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    @Override
    public void move() {
        if (direction == 0) {
            y = y + currentSpeed;
        } else if (direction == 2) {
            y = y - currentSpeed;
        } else if (direction == 1) {
            x = x + currentSpeed;
        } else if (direction == 3) {
            x = x - currentSpeed;
        }
    }

    @Override
    public void turnLeft() {
        direction = direction - 1;
        if (direction < 0) {
            direction = direction + 4;
        }

    }

    @Override
    public void turnRight() {
        direction = direction + 1;
        if (direction > 3) {
            direction = direction - 4;
        }

    }

    protected abstract double speedFactor();

    private void incrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    private void decrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }

    //TODO fix this method according to assignment instructions
    public void gas(double amount) {
        incrementSpeed(amount);
    }

    //TODO fix this method according to assignment instructions
    public void brake(double amount) {
        decrementSpeed(amount);
    }
}
