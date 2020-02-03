import java.awt.*;

public abstract class Car implements Movable{
    public  int nrDoors; // Number of doors on the car
    public double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    public Color color; // Color of the car
    public String modelName; //The car model name

    final static String INV_ARG = "Value not allowed"; //
<<<<<<< HEAD

    //Direction and coordinats
    public double x = 0;
    public double y = 0;
    public direction dir = direction.NORTH;

    public enum direction{
        NORTH, SOUTH, WEST, EAST
=======
    /**
     * Representations of Direction and position
     */
    private double x = 0;
    private double y = 0;
    private direction dir = direction.NORTH;
    
    public enum direction{
        NORTH, SOUTH, WEST, EAST
    }

    /**
     * Getters
     */
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public direction getDir(){
        return dir;
>>>>>>> a65c3d607116eb045af59f5a9a63b9822a9d4286
    }

    public int getNrDoors(){
        return nrDoors;
    }

    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    /**
     * Setters
     * @param clr which color should be set for the car
     */
    public void setColor(Color clr){
        color = clr;
    }

    /**
     * Starts / Stops the engine (affects currentSpeed)
     */
    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    /**
     * Increases the speed of the car.
      * @param amount a value in the interval [0,1]
     */
    public void gas(double amount) {
        if (amount >= 0 && amount <= 1) {
            double max = this.getEnginePower();
            double i = this.getCurrentSpeed();
            incrementSpeed(amount);
            double j = this.getCurrentSpeed();
            if (i > j) {
                currentSpeed = i;
            } else if (j > max) {
                currentSpeed = max;
            }
        } else {
            throw new IllegalArgumentException(INV_ARG);
        }
    }

    /**
     * Decreases the speed of the car
     * @param amount a value in the interval [0,1]
     */

    public void brake(double amount) {
        if (amount >= 0 && amount <= 1){
            double min = 0;
            double i = this.getCurrentSpeed();
            decrementSpeed(amount);
            double j = this.getCurrentSpeed();
            if (i < j){
                currentSpeed = i;
            } else if (j < min) {
                currentSpeed = min;
            }
        } else { throw new IllegalArgumentException(INV_ARG);
        }
    }

    /**
     * Moves the car in the current direction, turns the car left or right
     */
    @Override
    public void move() {
        if (dir == direction.SOUTH){
            y = y - currentSpeed;
        }
        if (dir == direction.NORTH){
            y = y + currentSpeed;
        }
        if (dir == direction.WEST){
            x = x - currentSpeed;
        }
        if (dir == direction.EAST){
            x = x + currentSpeed;
        }
    }
    @Override
    public void turnLeft() {
        if (dir == direction.SOUTH){
            dir = direction.EAST;
        }
        else if (dir == direction.EAST){
            dir = direction.NORTH;
        }
        else if (dir == direction.NORTH){
            dir = direction.WEST;
        }
        else if (dir == direction.WEST){
            dir = direction.SOUTH;
        }
    }
    @Override
    public void turnRight() {
        if (dir == direction.SOUTH){
            dir = direction.WEST;
        }
        else if (dir == direction.EAST){
            dir = direction.SOUTH;
        }
        else if (dir == direction.NORTH){
            dir = direction.EAST;
        }
        else if (dir == direction.WEST){
            dir = direction.NORTH;
        }
    }

    /**
     * Is called from the gas/brake method.
     * Does nothing unless a  method with the same name is also defined as Override in the car subclass
     */
    public void incrementSpeed(double amount){}
    public void decrementSpeed(double amount){}

}
