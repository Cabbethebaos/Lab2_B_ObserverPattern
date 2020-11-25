import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

/**
 * Se till att även bromsknappen är kopplad till bilen, så att den får effekt på er simulation (bromsvärdet får ni från samma snurra som
 * gasen hämtar sitt värde ifrån). Ni måste se till att modellens tillstånd uppdateras, och sen anropar tillbaka till CarView via CarController.
 *
 * Volvon åker just nu ut ur rutan. Se till att när bilen nuddar en vägg så stoppar den helt, inverterar sin riktning och startar igen.
 *
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
    ArrayList<Car> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo240());
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
            for (Car car : cars) {
                car.move();
                int x = (int) Math.round(car.getLocX());
                int y = (int) Math.round(car.getLocY());
                frame.drawPanel.moveit(x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars
                ) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars
        ) {
            car.brake(brake);
        }
    }
}
