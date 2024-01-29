import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Garage<T extends Car> {

    private int capacity;
    private final String name;
    private List<T> carInventory = new ArrayList<>(capacity);

    public Garage(int capacity){
        name = "Pimp my ride";
        this.capacity = capacity;
    }
    public List<T> getCarInventory(){
        return carInventory;
    }

    public void addCar(T car){
        this.carInventory.add(car);
    }

    public void pimpAllCars (){
        for(T car: carInventory) {
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
