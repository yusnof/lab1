import java.awt.*;
import java.lang.Math;
public class Car implements Movable{

    protected int nrDoors;
    protected Color color;
    protected double enginePower,currentSpeed,x,y,direction;
    protected String modelName;
    protected Car(){

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
    }//do we really need this method in Cars? because we overriding it twice

    public void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    @Override
    public void move() {
        // TODO  a is correct in 1st and 3rd quadrant but not others.
        double a=direction-(direction%90);
        if(currentSpeed<0){
            double hypotenuse= Math.abs(currentSpeed);
            double newY= currentSpeed*Math.sin(a);
            if(Math.sin(direction)<0) {
                y=y+newY;
            }
            else {
                y=y-newY;
            }
            double newX=currentSpeed*Math.cos(a);
            if(Math.cos(direction)<0) {
                x=x+newX;
            }
            else{
                x=x-newX;
            }
        }
        else{
            double newY= currentSpeed*Math.sin(a);
            if(Math.sin(direction)<0) {
                y=y-newY;
            }
            else {
                y=y+newY;
            }
            double newX=currentSpeed*Math.cos(a);
            if(Math.cos(direction)<0) {
                x=x-newX;
            }
            else{
                x=x+newX;
            }
        }
    }

    @Override
    public void turnLeft() {
        direction=(direction+15)%360;

    }

    @Override
    public void turnRight() {
        if(direction-15<0) {
            direction=360-(direction-15);
        }
        else {direction=direction-15;}
    }
}
