import java.awt.*;

public class Saab95 extends Car{

    public boolean turboOn;

    public Saab95(){
        nrDoors = 2;
        modelName = "Saab95";
        color = Color.red;
        turboOn=false;
        enginePower = 100; // not sure
        stopEngine();

    }
    public void setTurboOn(){
        turboOn = true;
    }

    public void setTurboOff(){
        turboOn = false;
    }
    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }
}
