package be.kdg.battleship.model;

public class Ship {


    private int type;
    private boolean horizontal;
    private int health;


    public Ship(int type, boolean horizontal) {
        this.type = type;
        this.horizontal = horizontal;
        this.health = type;
    }

    public void hit(){
        health--;
    }
    public boolean isAlive(){
        return health > 0;
    }

    public int getType() {
        return type;
    }

    public boolean isHorizontal() {
        return horizontal;
    }

    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }
}
