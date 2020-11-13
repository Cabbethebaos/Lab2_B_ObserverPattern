import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Saab95_Test {

    private Saab95 saab;

    @Before
    public void init() {
         saab = new Saab95();
    }

    @Test
    public void testTurboOn(){
        saab.setTurboOn();
        Assert.assertTrue(saab.checkTurboOn());
    }
    @Test
    public void testTurboOff(){
        saab.setTurboOff();
        Assert.assertTrue(!saab.checkTurboOn());
    }

    @Test
    public void testSpeedFactor(){
        if(saab.checkTurboOn())
            Assert.assertTrue(saab.speedFactor() == 125*0.01*1.3);
        else
            Assert.assertTrue(saab.speedFactor() == 125*0.01*1);
    }

    @Test
    public void testGas(){
        saab.setCurrentSpeed(0);
        saab.gas(0.5);
        Assert.assertTrue(0 < saab.getCurrentSpeed());
    }

    @Test
    public void testBrake(){
        saab.setCurrentSpeed(1);
        saab.brake(0.5);
        Assert.assertTrue(1 > saab.getCurrentSpeed());
    }

    @Test
    public void testSpeed(){
        while(saab.getCurrentSpeed() < saab.getEnginePower())
            saab.incrementSpeed(1);
        saab.incrementSpeed(0.5);
        Assert.assertTrue(saab.getCurrentSpeed() <= saab.getEnginePower());
    }

    @Test
    public void testStartEngine(){
        saab.setCurrentSpeed(0);
        saab.startEngine();
        Assert.assertTrue(0 < saab.getCurrentSpeed());
    }

}