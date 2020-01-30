/**
 * Abstract class Car is a super class to car models.
 */

import java.awt.*;

public abstract class Car implements Movable{
    public int nrDoors; // Number of doors on the car
    public double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    public Color color; // Color of the car
    public String modelName; //The car model name

    final static String INV_ARG = "Value not allowed"; //

    //Direction and coordinates
    private double x = 0;
    private double y = 0;
    private direction dir = direction.NORTH;
    
    public enum direction{
        NORTH, SOUTH, WEST, EAST
    }

    //Getters
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public direction getDir(){
        return dir;
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

    //Setters
    public void setColor(Color clr){
        color = clr;
    }

    //Car Components
    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

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

    public void incrementSpeed(double amount){} // Is overrriden if specified in subclass
    public void decrementSpeed(double amount){} // Is overrriden if specified in subclass

}
