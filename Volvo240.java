import java.awt.*;

public class Volvo240 extends Car {     // klass som ärver av den abstrakta klassen Car

    private final static double trimFactor = 1.25; // Trim nivå på volvo240

    public Volvo240() {         // Skapar volvo med 4 dörrar, färg: svart, 100 hk, namn: Volvo240, stoppar motorn
        super(4, Color.black, 100, "Volvo240");
    }

    public double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }   // Anger hur incrementSpeed skall öka. Returnerar en double beroende på trim och hk

}