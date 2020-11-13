import java.awt.*;

/**
 * Klass som ärver av den abstrakta klassen Car
 */ public class Volvo240 extends Car {     

   /**
    * Trim nivå på volvo240
    */
    private final static double trimFactor = 1.25; 

   /**
    * Skapar volvo med 4 dörrar, färg: svart, 100 hk, namn: Volvo240, stoppar motorn
    */ 
    public Volvo240() {       
    super(4, Color.black, 100, "Volvo240");
    }

   /**
    *
    * @return  Anger hur incrementSpeed skall öka. Returnerar en double beroende på trim och hk
    */ 
    public double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }  

}
