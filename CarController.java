public class CarController {


    protected CarModel m;

    public CarController(CarModel m){
        this.m = m;
    }

    public void gas(int gasAmount){
        m.gas(gasAmount);
    }
    public void brake (int brakeAmount) {
        m.brake(brakeAmount);
    }
    public void start(){
        m.start();
    }
    public void stop(){
        m.stop();
    }
    public void turboOn(){
        m.turboOn();
    }
    public void turboOff(){
        m.turboOff();
    }
    public void liftBed(){
        m.liftBed();
    }
    public void lowerBed(){
        m.lowerBed();
    }

}
