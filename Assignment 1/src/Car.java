import java.awt.*;

public abstract class Car implements Movable{
    public int nrDoors; // Number of doors on the car
    public double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    public Color color; // Color of the car
    public String modelName; //The car model name

    //Nya variable
    public double x;
    public double y;
    public direction dir;
    
    public enum direction{
        NORTH, SOUTH, WEST, EAST;
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

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
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
        if (dir == direction.EAST){
            dir = direction.NORTH;
        }
        if (dir == direction.NORTH){
            dir = direction.WEST;
        }
        if (dir == direction.WEST){
            dir = direction.SOUTH;
        }
    }

    @Override
    public void turnRight() {
        if (dir == direction.SOUTH){
            dir = direction.WEST;
        }
        if (dir == direction.EAST){
            dir = direction.SOUTH;
        }
        if (dir == direction.NORTH){
            dir = direction.EAST;
        }
        if (dir == direction.WEST){
            dir = direction.NORTH;
        }
    }


}
