package be.kdg.battleship.model;

public class Ship {


    private int type;
    private boolean horizontal;



    public Ship(int type, boolean horizontal) {
        this.type = type;
        this.horizontal = horizontal;

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
