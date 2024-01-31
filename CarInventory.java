import java.util.*;

public class CarInventory <T extends Car> {
    private int capacity;
    private List<T> inventory = new ArrayList<>(capacity);;

    public CarInventory(int capacity) {
    this.capacity = capacity;
    }
    public void addThing(){
    }
    public void removeThing() {
    }

}
