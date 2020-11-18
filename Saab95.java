import java.awt.*;

/**
 *
 *klass som ärver av den abstrakta klassen Car 
 */
public class Saab95 extends Car { 

    /**
     * internt tillstånd som beskriver om turbon på/av
     */
    private boolean turboOn;

    /**
     * Konstruktor som skapar saab med 2 dörrar, röd, 125 hk, turbo av, heter Saab95, stänger av motorn
     */
    public Saab95() {     
        super(Color.red, 125, "Saab95", 2);
        turboOn = false;
    }

    /**
     * Sätter på turbon
     */
    public void setTurboOn() {
        this.turboOn = true;
    }      

    /**
     * Stänger av turbon
     */
    public void setTurboOff() {
        turboOn = false;
    }         

    /**
     * Kollar om turbo på/av
     */
    public boolean checkTurboOn() {
        return this.turboOn;
    }   

    /**
     * Metod som anger vår speed factor ökar extra om turbo på
     */
    public double speedFactor() {          
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

}
