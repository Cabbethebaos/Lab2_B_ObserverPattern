import java.awt.*;

public class Scania extends Truck{

    /**
     * Instansvariabler för gradantalet för flaket.
     */
    private int degree;

    /**
     * Getter för att hämta graden av flaket.
     * @return
     */
    public int getDegree() { return degree; }
    /**
     * Setter för att sätta graden av flaket.
     * @param degree
     */
    public void setDegree(int degree) { this.degree = degree; }

    /**
     * Konstruktor som anropar superklassens konstruktor samt sätter degree till 0.
     * @param color
     * @param enginePower
     * @param modelName
     */
    public Scania(Color color, int enginePower, String modelName) {
        super(color, enginePower, modelName);
        degree = 0;
    }

    /**
     * Metod som höjer flaket till max 70 grader samtidigt när lastbilen står still.
     * @param raise
     */
    public void raiseBed(int raise){
        if(degree + raise <= 70 && this.getCurrentSpeed() == 0)
            degree += raise;
        else
            System.out.println("Either can't raise to by such degree or vechile is moving");
    }

    /**
     * Metod som sänker flaket till max 0 grader
     * @param lower
     */
    public void lowerBed(int lower){
        if(degree - lower >= 0)
            degree -= lower;
        else
            System.out.println("Can't lower to by such degree");
    }

    /**
     * En överskrivning av move metoden så att lastbilen inte kan köra när flaket är höjt.
     */
    @Override
    public void move() {
        if (this.degree == 0)
            super.move();
        else
            System.out.println("Bed is not at zero degrees");
    }
}
