import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Volvo240_Test {

    private Volvo240 volvo;

    @Before
    public void init() {
        volvo = new Volvo240();
    }


    @Test
    public void testSpeedFactor(){
        Assert.assertTrue(volvo.speedFactor() == 100*0.01*1.25);
    }

    @Test
    public void testGas(){
        volvo.setCurrentSpeed(0);
        volvo.gas(0.5);
        Assert.assertTrue(0 < volvo.getCurrentSpeed());
    }

    @Test
    public void testBrake(){
        volvo.setCurrentSpeed(1);
        volvo.brake(0.5);
        Assert.assertTrue(1 > volvo.getCurrentSpeed());
    }


    @Test
    public void testSpeed(){
        while(volvo.getCurrentSpeed() < volvo.getEnginePower())
            volvo.incrementSpeed(1);
        volvo.incrementSpeed(0.5);
        Assert.assertTrue(volvo.getCurrentSpeed() <= volvo.getEnginePower());
    }

    @Test
    public void testStartEngine(){
        volvo.setCurrentSpeed(0);
        volvo.startEngine();
        Assert.assertTrue(0 < volvo.getCurrentSpeed());
    }

    // Assert/Equals?

}
