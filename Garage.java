import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Garage<T extends Car> {

    private int capacity;

    private String name;

    private List<Car> carInventory = new ArrayList<>(capacity);
    private List<Car> acceptedModels;
    public Garage(int capacity,List<Car> acceptedModels){
        name = "Pimp my ride";
        this.acceptedModels = acceptedModels;
        this.capacity = capacity;
    }
    public List<T> getCarInventory(){
        return carInventory;
    }

    public void addCar(T car){
        this.carInventory.add(car);
    }

    public void pimpAllCars (){
        for(Car car: carInventory) {
            car.modelName += "BromBrom";
            car.setColor(Color.MAGENTA);
            car.enginePower += 1000;
        }
    }
    public void removeCar(T car){
        if (!carInventory.isEmpty()) {
            this.carInventory.remove(car);
        }
    }

}
