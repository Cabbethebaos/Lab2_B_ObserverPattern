import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

public class Car_Test {

    private Volvo240 volvo;

    @Before
    public void init() {
        volvo = new Volvo240();
    }

    @Test
    public void testGetNrDoors() {
        Assert.assertTrue(volvo.getNrDoors() == volvo.getNrDoors());
    }

    @Test
    public void testGetEnginePower() {
        Assert.assertTrue(volvo.getEnginePower() == volvo.getEnginePower());
    }

    @Test
    public void testGetColor() {
        Assert.assertTrue(volvo.getColor() == Color.black);
    }

    @Test
    public void testSetColor() {
        System.out.println(volvo.getColor().toString());
        volvo.setColor(Color.red);
        Assert.assertTrue(volvo.getColor() == Color.red);
    }

    @Test
    public void testStartEngine() {
        volvo.startEngine();
        Assert.assertTrue(volvo.getCurrentSpeed() == 0.1);
    }

    @Test
    public void testStopEngine() {
        volvo.stopEngine();
        Assert.assertTrue(volvo.getCurrentSpeed() == 0);
    }

    @Test
    public void testIncrementSpeed(){
        volvo.setCurrentSpeed(0);
        volvo.incrementSpeed(1);
        Assert.assertTrue(volvo.getCurrentSpeed() > 0);
    }

    @Test
    public void testDecrementSpeed(){
        volvo.setCurrentSpeed(1);
        volvo.decrementSpeed(1);
        Assert.assertTrue(volvo.getCurrentSpeed() < 1);
    }

    @Test
    public void testGas() {
        volvo.setCurrentSpeed(0);
        volvo.gas(0.5);
        Assert.assertTrue(0 < volvo.getCurrentSpeed());
    }

    @Test
    public void testBrake() {
        volvo.setCurrentSpeed(1);
        volvo.brake(0.5);
        Assert.assertTrue(1 > volvo.getCurrentSpeed());
    }

    @Test
    public void testMove() {
        volvo.setCurrentSpeed(10); // Riktad norr
        volvo.move();
        Assert.assertTrue(0 < volvo.getLocY());
    }

    @Test
    public void testTurnLeft() {
        if (volvo.getDirr() == 0){// om dirr west --> north
            volvo.turnLeft();
            Assert.assertTrue(volvo.getDirr() == 3);
        }
        else{
            int temp = volvo.getDirr();
            volvo.turnLeft();
            Assert.assertTrue(temp > volvo.getDirr());
        }

    }

    @Test
    public void testTurnRight() {
        if (volvo.getDirr() == 3){// om dirr west --> north
            volvo.turnRight();
            Assert.assertTrue(volvo.getDirr() == 0);
        }
        else{
            int temp = volvo.getDirr();
            volvo.turnRight();
            Assert.assertTrue(temp < volvo.getDirr());
        }

    }
}
