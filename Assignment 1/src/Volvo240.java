/**
 * Is a sub class to abstract class Car.
 */

import java.awt.*;

public class Volvo240 extends Car{

    private final static double trimFactor = 1.25;
    
    public Volvo240(){
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
        stopEngine();
    }

    private double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }

    @Override
    public void incrementSpeed(double amount) {
            currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }
    @Override
    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

}
