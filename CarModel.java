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
     *
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
            if (car instanceof Saab95)
                ((Saab95) car).setTurboOn();
    }

    /**
     * Stänger av på turbon om Saab95
     */
    protected void turboOff() {
        for (Vehicle v : vehicles)
            if (v instanceof Saab95)
                ((Saab95) v).setTurboOff();
    }

    /**
     * Stänger av på turbon om Saab95
     */
    protected void liftBed() {
        for (Vehicle v : vehicles)
            if (v instanceof Scania)
                ((Scania) v).liftBed(45);
    }

    /**
     * Stänger av på turbon om Saab95
     */
    protected void lowerBed() {
        for (Vehicle v : vehicles)
            if (v instanceof Scania)
                ((Scania) v).lowerBed(45);
    }

    protected void addCar() {
        CarFactory carAdder = new CarFactory();

        Random random = new Random();
        int randomval = random.nextInt(3);
        System.out.println(randomval);

        Vehicle toBeAdded = carAdder.createRandom(randomval);
        System.out.println(toBeAdded.getModelName());
        //testar lite med att lägga till random bilar   */


        this.vehicles.add(toBeAdded);

    }

    protected void removeCar() {
        if (getVehicles().size() > 0) {
            int randomval = new Random().nextInt(vehicles.size());

            this.vehicles.remove(this.vehicles.size() - 1);

        }

    }

    public void move() {
        for (Vehicle v : vehicles) {
            if(v.getLocation().y > 500 || v.getLocation().y < 0 || v.getLocation().x < 0 || v.getLocation().x > 700)
                v.turnAround();
            v.move();
        }
    }
}