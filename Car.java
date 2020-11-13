import java.awt.*;

public abstract class Car implements Movable {      // Abstrakt klass som implementerar interfacet movable

    private Color color; // Color of the car
    private String modelName; // The car model name
    private double currentSpeed; // The current speed of the car
    private double enginePower; // Engine power of the car
    private int nrDoors; // Number of doors on the car
    private double locX = 0; //X coordinate of Location of Car
    private double locY = 0; //Y coordinate of location of Car
    private int dirr = 0; //0 = north, 1=east, 2=south, 3=west

    public Car(int nrDoors, Color color, int enginePower, String modelName) {
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        stopEngine();

    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public double getLocY() {
        return locY;
    }

    public void setLocY(double locY) {
        this.locY = locY;
    }

    public double getLocX() {
        return locX;
    }

    public void setLocX(double locX) {
        this.locX = locX;
    }

    public int getDirr() {
        return dirr;
    }

    public void setDirr(int dirr) {
        this.dirr = dirr;
    }

    public void setEnginePower(double enginePower) {
        this.enginePower = enginePower;
    }

    public void setNrDoors(int nrDoors) {
        this.nrDoors = nrDoors;
    }

    protected int getNrDoors() {
        return this.nrDoors;
    }       // Hämtar ant dörrar

    protected double getEnginePower() {
        return this.enginePower;
    }       // hämtar hk

    protected double getCurrentSpeed() {        // Hämtar nuvarande hastighet
        return this.currentSpeed;

    }

    protected Color getColor() {
        return this.color;
    }           // Hämtar färg

    protected void setColor(Color clr) {
        this.color = clr;
    }     // sätter färg

    protected void startEngine() {
        this.currentSpeed = 0.1;
    }       // Startar motorn

    protected void stopEngine() {
        this.currentSpeed = 0;
    }           // Stryper motorn

    protected abstract double speedFactor();                        // abstrakt metod som implementeras av subklasser

    public void incrementSpeed(double amount) {     // Ökar speed till högst 'enginePower'
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    public void decrementSpeed(double amount) {     // Minskar speed till minst '0'
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

    // TODO fix this method according to lab pm
    public void gas(double amount) {        // Som incrementSpeed fast tar endast specifika värden
        if (amount >= 0 && amount <= 1) // Eftersom vi endast tillåter värden mellan 0 och 1 kan bilen inte bromsas av denna funktion
            incrementSpeed(amount);
        else
            throw new RuntimeException("invalid number");
    }

    // TODO fix this method according to lab pm
    public void brake(double amount) {      // Som decrementSpeed fast tar endast specifika värden
        if (amount >= 0 && amount <= 1) // Eftersom vi endast tillåter värden mellan 0 och 1 kan bilen inte öka farten av denna funktion
            decrementSpeed(amount);
        else
            throw new RuntimeException("invalid number");
    }

    public void move() {    // Rör sig i den riktningen som bilen pekar
        if (dirr == 0) {
            locY += this.getCurrentSpeed();
        } else if (dirr == 1) {
            locX += this.getCurrentSpeed();
        } else if (dirr == 2) {
            locY -= this.getCurrentSpeed();
        } else locX -= this.getCurrentSpeed();

    }

    public void turnLeft() {        // Svänger vänster
        if (dirr == 0) {
            dirr = 3;
        } else dirr -= 1;
    }

    public void turnRight() {       // Svänger höger
        if (dirr == 3) {
            dirr = 0;
        } else dirr += 1;
    }

    public void setCurrentSpeed(double speed) {
        currentSpeed = speed;
    }   // Sätter hastigheten till det angivna värde
}