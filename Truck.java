import java.awt.*;

/**
 * Abstakt klass för truck objekt så man ej skall kunna lasta annat än Car objekt i Transports.
 */
public abstract class Truck extends Vehicle {
    public Truck(Color color, int enginePower, String modelName) {
        super(color, enginePower, modelName);
    }

}
