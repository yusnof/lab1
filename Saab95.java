import java.awt.*;

public class Saab95 extends Car{

    public boolean turboOn;

    public Saab95(){
        nrDoors = 2;
        modelName = "Saab95";
        color = Color.red;
        turboOn=false;
        enginePower = 100;
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
}
