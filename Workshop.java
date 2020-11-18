import java.util.ArrayList;
import java.util.*;

public class Workshop<T> {

    /**
     * Variabel initiering
     */
    private int capacity;
    private Set<T> brokenCars;

    /**
     * En metod som genriskt tar en typparameter i ett Set.
     * @return
     */
    public Set<T> getBrokenCars() {
        return brokenCars;
    }

    /**
     * Konstruktor som tar en int kapacitet som parameter samt initierar den. Skapar dessutom ett LinkedHashSet som tar den generiska datan som angets.
     * @param capacity
     */
    public Workshop(int capacity){
        this.capacity = capacity;
        brokenCars = new LinkedHashSet<>();
    }
//<T extends VehicleType>

    /**
     * Metod som tar objekt av den angivna typen (dvs, det man skapade Workshop till) sedan adderar den till HashMap'n
     * @param car
     */
    public void addToWorkshop(T car){
        if(brokenCars.size() < capacity)
            this.brokenCars.add(car);
        else
            System.out.println("Workshop is full! Max capacity: " + capacity);
    }

    /**
     * Metod som tar bort givet objekt från mappen.
     * @param car
     */
    public void removeFromWorkshop(T car){
        this.brokenCars.remove(car);
    }
}
