import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

public class CarTransport_Test {

    private CarTransport transport;
    private Volvo240 volvo240;

    @Before
    public void init() {
        transport = new CarTransport(Color.BLUE, 350, "Scania", 10);
        volvo240 = new Volvo240();
    }


    @Test
    public void testLoadCar(){
        transport.setRampDown();
        transport.loadCar(volvo240);
        Assert.assertTrue(transport.carsLoaded.contains(volvo240));
    }

    @Test
    public void testUnloadCar(){
        transport.setRampDown();
        transport.loadCar(volvo240);
        transport.unloadCar();
        Assert.assertTrue(!transport.carsLoaded.contains(volvo240));
    }

}
