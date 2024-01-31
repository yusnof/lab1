import java.awt.*;

public class Scania extends Truck {

    public Scania(){
        capacity=3500;
        weight=3000;
        modelName = "Scania";
        nrDoors = 2;
        enginePower=750;
        color = Color.pink;
        truckBedAngle = 0;
        stopEngine();
    }
    @Override
    public void raiseTruckBed(){
        if(truckBedAngle <= 60 && truckBedAngle >= 0 && currentSpeed == 0) {
            truckBedAngle += 10;
            isTruckBedDown = false;
        }
    }
    @Override
    public void lowerTruckBed() {

        if (truckBedAngle <= 70 && truckBedAngle >= 10 && currentSpeed == 0) {
            truckBedAngle -= 10;
        }
        if (truckBedAngle == 0) {
            isTruckBedDown = true;
        }

    }
    public int getTruckBedAngle(){
        return this.truckBedAngle;
    }
    @Override
    public void move(){
        if(truckBed.isTruckBedDown()) {
            super.move();
        }
    }
}
