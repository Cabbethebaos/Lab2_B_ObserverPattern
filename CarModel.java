import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarModel {

    /**
     * Lista som håller alla bilarna i programmet
     */
    protected List<Vehicle> vehicles = new ArrayList<>();

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    protected void start() {
        for (Vehicle car : vehicles)
            car.startEngine();
    }

    protected void stop() {
        for (Vehicle car : vehicles)
            car.stopEngine();
    }

    // Calls the gas method for each car once
    protected void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : vehicles)
            car.gas(gas);

    }

    /**
     * Anropar BRAKE metoden för varje car i cars listan.
     * @param amount
     */
    protected void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : vehicles)
            car.brake(brake);

    }

    /**
     * Sätter på turbon om Saab95
     */
    protected void turboOn() {
        for (Vehicle car : vehicles)
            if(car instanceof Saab95 )
                ((Saab95) car).setTurboOn();
    }

    /**
     * Stänger av på turbon om Saab95
     */
    protected void turboOff() {
        for (Vehicle v : vehicles)
            if(v instanceof Saab95 )
                ((Saab95) v).setTurboOff();
    }

    /**
     * Stänger av på turbon om Saab95
     */
    protected void liftBed() {
        for (Vehicle v : vehicles)
            if(v instanceof Scania )
                ((Scania) v).liftBed(45);
    }

    /**
     * Stänger av på turbon om Saab95
     */
    protected void lowerBed() {
        for (Vehicle v : vehicles)
            if(v instanceof Scania )
                ((Scania) v).lowerBed(45);
    }

    protected void addCar(){
        CarFactory carAdder = new CarFactory();
        Random random = new Random();
        int randomval = random.nextInt(2);

        Vehicle toBeAdded = carAdder.createRandom(randomval);

        this.vehicles.add(toBeAdded);

    }

}
