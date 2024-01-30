import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CarTransport extends Truck{
    private List<Car> carInventory = new ArrayList<>(10);
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
        return carInventory;
    }
    public void addCar(Car car){
        if (currentSpeed == 0 && isTruckBedDown && car.getClass() != this.getClass() && measureDistance(car,this)<=3 && isCapacityNotFull(car)) {
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
        if (calculateLoad() + car.getWeight() <= capacity && carInventory.size() < 10) {
            return true;
        }
        else { return false; }
    }

    public int calculateLoad() {
        int load = 0;
        for (Car car : carInventory) {
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
}
