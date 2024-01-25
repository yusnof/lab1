import java.awt.*;

public class Scania extends Truck {


    Scania(){
        modelName = "Scania";
        nrDoors = 2;
        enginePower=750;
        color = Color.pink;
        truckBedAngle = 0;
        stopEngine();
    }
    @Override
    public void raiseTruckBed(){
        //TODO JUint testing
        if(truckBedAngle <= 60 && truckBedAngle >= 0 && currentSpeed == 0) {
            truckBedAngle += 10;
            isTruckBedDown = false;
        }
    }
    @Override
    public void lowerTruckBed() {
        //TODO JUnit testing
        if (truckBedAngle <= 70 && truckBedAngle >= 10 && currentSpeed == 0) {
            truckBedAngle -= 10;
        }
        if (truckBedAngle == 0) {
            isTruckBedDown = true;
        }

    }
    public double getTruckBedAngle(){
        return this.truckBedAngle;
    }

}
