import java.awt.*;

public class Saab95 extends Car{

    public boolean turboOn;
    //public int nrDoors; // Number of doors on the car
    //public double enginePower; // Engine power of the car
    //public double currentSpeed; // The current speed of the car
    //public Color color; // Color of the car
    //public String modelName; // The car model name
    
    public Saab95(){
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
	    turboOn = false;
        modelName = "Saab95";
        stopEngine();
    }

    
    /*public int getNrDoors(){
        return nrDoors;
    }*/

    /*public double getEnginePower(){
        return enginePower;
    }*/

    /*public double getCurrentSpeed(){
        return currentSpeed;
    }*/

    /*public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
	    color = clr;
    }*/

    /*public void startEngine(){
	    currentSpeed = 0.1;
    }

    public void stopEngine(){
	    currentSpeed = 0;
    }*/

    private void setTurboOn(){
	    turboOn = true;
    }

    private void setTurboOff(){
	    turboOn = false;
    }
    
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

    private void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    private void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }
    
    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }
}