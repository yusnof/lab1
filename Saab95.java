import java.awt.*;

public class Saab95 extends Car{

    public boolean turboOn;

    protected Saab95(){
        modelName = "Saab95";
        turboOn=false;
    }
    public Saab95(Color color, double currentSpeed,double enginePower) {
        super(color,currentSpeed,enginePower);
        new Saab95();
    }

    public void setTurboOn(){
        turboOn = true;
    }

    public void setTurboOff(){
        turboOn = false;
    }

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
