import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CarTransport extends Truck {
    private CarInventory carInventory = new CarInventory();
    public CarTransport() {
        capacity = 37500;
        weight = 10000;
        modelName = "Lorry";
        nrDoors = 2;
        enginePower = 1000;
        color = Color.YELLOW;
        isTruckBedDown = true;
        stopEngine();
    }

    public List<Car> getCarInventory () {
        return carInventory.getInventory();
    }

    public TruckBed getTruckBed() {
        return truckBed;
    }

    public void addCar(Car car){
        if (currentSpeed == 0 && truckBed.isTruckBedDown() && car.getClass() != this.getClass() && measureDistance(car,this)<=3 && isCapacityNotFull(car)) {
            carInventory.add(car);
            car.x = this.getX();
            car.y = this.getY();
        }
    }
    public void removeCar() {
        if(isTruckBedDown) {
            carInventory.remove(0);
        }
    }

    public boolean isCapacityNotFull(Car car) {
        if (calculateLoad() + car.getWeight() <= truckBed.getmaxWeight() && carInventory.getInventory().size() < carInventory.getCapacity()) {
            return true;
        }
        else { return false; }
    }

    public int calculateLoad() {
        int load = 0;
        for (Car car : carInventory.getInventory()) {
            load += car.getWeight();
        }
        return load;
    }
    @Override
    public void move() {
        if(isTruckBedDown) {
            super.move();
            for (Car car : carInventory) {
                car.x = this.getX();
                car.y = this.getY();
            }
        }
    }

    @Override
    public void raiseTruckBed() {
        truckBed.setTruckBed(false);
    }

    @Override
    public void lowerTruckBed() {
        truckBed.setTruckBed(true);
    }
}
