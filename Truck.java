public abstract class Truck extends Car{
    protected boolean isTruckBedDown;
    protected int truckBedAngle;
    protected int capacity;
    public void raiseTruckBed() {
        isTruckBedDown = false;
    }
    public void lowerTruckBed() {
        isTruckBedDown = true;
    }

    @Override
    public void move(){
        if(isTruckBedDown) {
            super.move();
        }
    }
}
