import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class App {

    private final int delay = 50;
    private Timer timer = new Timer(delay, new TimerListener());

    private CarModel m;
    private CarController cc;


    /**
     * Observer som del av
     */
    private List<Observer> observers = new ArrayList<>();

    public static void main(String[] args) {
        App app = new App();

        app.run();

        // Start the timer
        app.timer.start();

    }

    /**
     * Här anger vi vad som skall köras och finnas med i programmet
     */
    public void run(){
        this.m = new CarModel();

        m.vehicles.add(new Volvo240());
        m.vehicles.add((new Saab95()));
        m.vehicles.add(new Scania(Color.red, 278, "Scania"));

        this. cc = new CarController(m);

        observers.add(new SpeedView(m));
        observers.add(new CarView(cc));

    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            // NYTT
            for (Observer observer : observers)
                observer.update();
        }
    }

}
