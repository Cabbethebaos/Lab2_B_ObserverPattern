import java.awt.*;

public class CarFactory {

    public Vehicle createSaab95(){
        return new Saab95();
    }
    public Vehicle createVolvo240(){
        return new Volvo240();
    }
    public Vehicle createScania(){
        return new Scania(Color.red, 420, "Scania");
    }

    public Vehicle createRandom(int randomNumber){
       Vehicle newVehicle;
        if(randomNumber == 0){
            newVehicle = createSaab95();
        }
        if (randomNumber == 1){
            newVehicle = createVolvo240();
        }

        else    newVehicle = createScania();

        return newVehicle;
    }


}
