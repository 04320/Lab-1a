import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static junit.framework.TestCase.assertTrue;

public class test {
    Volvo240 test1 = new Volvo240();
    Saab95 test2 = new Saab95();

    @Before
    public void init(){

    }
    @Test
    public void checknrDoors(){
        assertTrue(test1.getNrDoors() == 4 && test2.getNrDoors() == 2);
    }
    @Test
    public void checkColor(){
        assertTrue(test1.getColor() == Color.black && test2.getColor() == Color.red);
    }
    @Test
    public void checkEnginePower(){
        assertTrue(test1.getEnginePower() == 100 && test2.getEnginePower() == 125);
    }
    @Test
    public void checkSpeedFactor(){
        assertTrue(test1.getCurrentSpeed() == 0 && test2.getCurrentSpeed() == 0);
    }
    @Test
    public void checkGas(){
        test1.startEngine();
        double x = test1.getCurrentSpeed();
        test1.gas(0.5);
        assertTrue(test1.getCurrentSpeed() > x);

    }
    @Test
    public void checkStartEngine(){
        test1.startEngine();
        test2.startEngine();
        assertTrue(test1.getCurrentSpeed() == 0.1 && test2.getCurrentSpeed() == 0.1);
    }
    @Test
    public void checkStopEngine(){
        test1.startEngine();
        test1.stopEngine();
        assertTrue(test1.getCurrentSpeed() == 0);
    }
    @Test
    public void checkIsTurboOff(){
        assertTrue(test2.turboOn == false);
    }

}
