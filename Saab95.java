import java.awt.*;

public class Saab95 extends Car {   /** klass som ärver av den abstrakta klassen Car */

    private boolean turboOn; /** internt tillstånd som beskriver om turbon på/av */

    public Saab95() {       /** Konstruktor som skapar saab med 2 dörrar, röd, 125 hk, turbo av, heter Saab95, stänger av motorn */
        super(2, Color.red, 125, "Saab95");
        turboOn = false;
    }

    public void setTurboOn() {
        this.turboOn = true;
    }       /** Sätter på turbon */

    public void setTurboOff() {
        turboOn = false;
    }           /** Stänger av turbon */

    public boolean checkTurboOn() {
        return this.turboOn;
    }   /** Kollar om turbo på/av */

    public double speedFactor() {           /** Metod som anger vår speed factor ökar extra om turbo på */
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

}
