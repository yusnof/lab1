import junit.framework.TestCase;
import org.junit.Test;

import java.awt.*;

public class CarTest extends TestCase {

    Car volvo = new Volvo240();
    Car saab = new Saab95();


    double amount;
    public void testGetNrDoors() {
        assertEquals(4,volvo.getNrDoors());
        assertEquals(2,saab.getNrDoors());
    }

    public void testGetEnginePower() {
        assertEquals(120.0, volvo.getEnginePower());
        assertEquals(100.0, saab.getEnginePower());
    }

    public void testGetCurrentSpeed() {
        volvo.stopEngine();
        assertEquals(0.0,volvo.getCurrentSpeed());
        assertEquals(0.0,volvo.getCurrentSpeed());
    }

    public void testGetColor() {
        assertEquals(Color.black,volvo.getColor());
        assertEquals(Color.red, saab.getColor());
    }

    public void testSetColor() {
        volvo.setColor(Color.blue);
        saab.setColor(Color.gray);
        assertEquals(Color.blue,volvo.getColor());
        assertEquals(Color.gray, saab.getColor());
    }

    public void testStartEngine() {
        volvo.startEngine();
        saab.startEngine();
        assertEquals(0.1,volvo.getCurrentSpeed());
        assertEquals(0.1,saab.getCurrentSpeed());
    }

    public void testStopEngine() {
        volvo.stopEngine();
        saab.stopEngine();
        assertEquals(0.0,volvo.getCurrentSpeed());
        assertEquals(0.0,saab.getCurrentSpeed());

    }

    public void testSpeedFactor() {
        assertEquals(1.25*0.01*120,volvo.speedFactor());
        assertEquals(1*0.01*100,saab.speedFactor());

    }

    public void testIncrementSpeed() {
         amount = 0.0;
         volvo.stopEngine();
         saab.stopEngine();
         assertEquals(0.0,Math.min(volvo.getCurrentSpeed() + volvo.speedFactor() * amount,volvo.enginePower));
         assertEquals(0.0,Math.min(saab.getCurrentSpeed() + saab.speedFactor() * amount,saab.enginePower));
    }

    public void testDecrementSpeed() {
        double testAmount = 10.0;
        //Current speed 10.0, lower by 5. Expected test result 5.0
        volvo.stopEngine();
        volvo.incrementSpeed(testAmount);
        volvo.decrementSpeed(5);
        assertEquals(7.5, volvo.getCurrentSpeed());
    }

    public void testFindAngleA() {
        assertEquals(60.0,volvo.findAngleA(60)); //
        assertEquals(30.0,volvo.findAngleA(150)); //
        assertEquals(50.0,volvo.findAngleA(230)); //
        assertEquals(40.0,volvo.findAngleA(320)); //
    }

    public void testMove() {
        //Car is not moving, expected return 0,0

        volvo.stopEngine();
        volvo.x = 0.0;
        volvo.y = 0.0;
        volvo.direction = 10.0;
        volvo.move();

        assertEquals(0.0,volvo.x);
        assertEquals(0.0, volvo.y);

        //Car moving at speed 10, direction 10
        volvo.x = 0.0;
        volvo.y = 0.0;

        volvo.stopEngine();
        volvo.incrementSpeed(10);
        volvo.direction = 10.0;
        volvo.move();

        assertEquals(volvo.y, (Math.sin(Math.toRadians(volvo.findAngleA(volvo.direction)))*volvo.getCurrentSpeed()));
        assertEquals(volvo.x, (Math.cos(Math.toRadians(volvo.findAngleA(volvo.direction)))*volvo.getCurrentSpeed()));

    }

    public void testTurnLeft() {
    }

    public void testTurnRight() {
    }
    public void testGas(){
        //test in case of gas is more than 1
        volvo.currentSpeed = 100;
        volvo.gas(2);
        assertEquals(volvo.currentSpeed, 100.0);

        //test case were the speed should increase
        volvo.currentSpeed = 100;
        volvo.gas(1);
        assertEquals(volvo.currentSpeed, 101.5);

    }
    public void testBrake(){
       volvo.currentSpeed=100.0;
       double d = volvo.currentSpeed;
       volvo.brake(0.4);
       assertTrue(volvo.currentSpeed < d);
    }
}