package be.kdg.battleship.model;

public class Ship {


    private int type;
    private boolean vertical;
    private int followNumber;



    public Ship(int type, boolean vertical, int followNumber) {
        this.type = type;
        this.vertical = vertical;
        this.followNumber = followNumber;


    }


    public int getType() {
        return type;
    }

    public boolean isVertical() {
        return vertical;
    }

    public void setVertical(boolean vertical) {
        this.vertical = vertical;
    }

    public int getFollowNumber() {
        return followNumber;
    }
}
