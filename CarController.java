import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.util.List;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

/**
 * Sätt in Saab95, Scania och deras respektive bilder med 100 pixlars avstånd i Y-led från varandra (alla avbildas ursprungligen med X=0).
 * Koppla turbo-knapparna till Saaben och flakknapparna till Scania. Koppla "starta och stoppa alla bilar"-knapparna till bägge. Även dessa
 * bilar ska förhindras att åka utanför rutan.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    public List<Vehicle> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo240());
        cc.cars.add(new Scania(Color.red, 278, "Scania"));
        cc.cars.add(new Saab95());

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }



    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle car : cars) {
                if(car.getLocation().y > 500 || car.getLocation().y < 0 || car.getLocation().x < 0 || car.getLocation().x > 700)
                    car.turnAround();

                car.move();
                int x = (int) Math.round(car.getLocation().x);
                int y = (int) Math.round(car.getLocation().y);
                frame.drawPanel.moveit(x, y, cars.indexOf(car));
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    // Allt nedan är egentligen del av Modell ifall av M-V-C

    public void start() {
        for (Vehicle car : cars)
            car.startEngine();
    }

    public void stop() {
        for (Vehicle car : cars)
            car.stopEngine();
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars)
            car.gas(gas);

    }

    /**
     * Anropar BRAKE metoden för varje car i cars listan.
     * @param amount
     */
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : cars)
            car.brake(brake);

    }

    /**
     * Sätter på turbon om Saab95
     */
    void turboOn() {
        for (Vehicle car : cars)
            if(car instanceof Saab95 )
                ((Saab95) car).setTurboOn();
    }

    /**
     * Stänger av på turbon om Saab95
     */
    void turboOff() {
        for (Vehicle v : cars)
            if(v instanceof Saab95 )
                ((Saab95) v).setTurboOff();
    }

    /**
     * Stänger av på turbon om Saab95
     */
    void liftBed() {
        for (Vehicle v : cars)
            if(v instanceof Scania )
                ((Scania) v).liftBed(45);
    }

    /**
     * Stänger av på turbon om Saab95
     */
    void lowerBed() {
        for (Vehicle v : cars)
            if(v instanceof Scania )
                ((Scania) v).lowerBed(45);
    }
}