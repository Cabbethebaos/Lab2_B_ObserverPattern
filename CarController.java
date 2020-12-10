public class CarController {

    protected CarModel m;

    public CarController(CarModel m){
        this.m = m;
    }

    protected void gas(int gasAmount){
        m.gas(gasAmount);
    }
    protected void brake (int brakeAmount) {
        m.brake(brakeAmount);
    }
    protected void start(){
        m.start();
    }
    protected void stop(){
        m.stop();
    }
    protected void turboOn(){
        m.turboOn();
    }
    protected void turboOff(){
        m.turboOff();
    }
    protected void liftBed(){
        m.liftBed();
    }
    protected void lowerBed(){
        m.lowerBed();
    }

}
