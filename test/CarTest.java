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
        assertEquals(120.0,volvo.getEnginePower());
        assertEquals(100.0, saab.getEnginePower());
    }

    public void testGetCurrentSpeed() {
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
         assertEquals(Math.min(volvo.getCurrentSpeed() + volvo.speedFactor() * amount,volvo.enginePower),0.0);
         assertEquals(Math.min(saab.getCurrentSpeed() + saab.speedFactor() * amount,saab.enginePower),0.0);
    }

    public void testDecrementSpeed() {
        amount = 0.0;
        volvo.stopEngine();
        saab.stopEngine();

        assertEquals(Math.max(volvo.getCurrentSpeed() - volvo.speedFactor() * amount,0),0);
        assertEquals(Math.max(saab.getCurrentSpeed() - saab.speedFactor() * amount,0),0);
    }

    public void testMove() {
        volvo.stopEngine();
        saab.stopEngine();


    }

    public void testTurnLeft() {
    }

    public void testTurnRight() {
    }
}