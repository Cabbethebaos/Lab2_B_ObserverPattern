import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

public class ScaniaTest {

    private Scania scania;

    @Before
    public void init() {
        scania = new Scania(Color.BLUE, 350, "Scania");
    }

    @Test
    public void testRaiseBed(){
        scania.liftBed(70); // 0 standard
        Assert.assertTrue(scania.getDegree() == 70);
    }

    @Test
    public void testMove() {
        scania.setCurrentSpeed(10); // Riktad norr
        scania.move();
        Assert.assertTrue(0 < scania.getLocation().y);
    }
}