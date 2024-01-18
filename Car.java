import java.awt.*;

public class Car {

    protected int nrDoors;
    protected Color color;
    protected double enginePower;
    protected double currentSpeed;
    protected String modelName;

    public Car(){

    }

    public Car(Color color, double currentSpeed, double enginePower){
        this.color=color;
        this.currentSpeed=currentSpeed;
        this.enginePower=enginePower;
        this.modelName=modelName;
        startEngine();
    }
    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower() { return enginePower; }

    public double getCurrentSpeed(){return currentSpeed;}
    public Color getColor(){return color;}

    public void setColor(Color color){
        this.color = color;
    }
    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    public double speedFactor() {
        return enginePower * 0.01;
    }

    public void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }
}
