package be.kdg.battleship.model;

public class Cell {
    private int x;
    private int y;
    private int type;
    private Ship ship = null;
    private boolean wasShot;
    private boolean marked;
    private boolean missed;
    private boolean sunken;

    private Board board;



    public Cell(int x, int y, Board board) {
        this.x = x;
        this.y = y;
        this.board = board;
        //this.ship = null;
        this.type = 0;
        this.missed = false;
        this.wasShot = false;
        this.marked = false;
        this.sunken = false;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setMarked(boolean marked) {
        this.marked = marked;
    }

    public void setWasShot(boolean wasShot) {
        this.wasShot = wasShot;
    }

    public void setMissed(boolean missed) {
        this.missed = missed;
    }

    public boolean isWasShot() {
        return wasShot;
    }

    public boolean isSunken() {
        return sunken;
    }

    public void setSunken(boolean sunken) {
        this.sunken = sunken;
    }

    public boolean isMarked() {
        return marked;
    }

    public boolean isMissed() {
        return missed;
    }
}
