package be.kdg.battleship.model;

public class Cell {
    private int x;
    private int y;


    private int type;
    private int followNumber;
    private Ship ship = null;


    private boolean shot;
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
        this.followNumber = 0;
        this.missed = false;
        this.shot = false;
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

    public void setShot(boolean shot) {
        this.shot = shot;
    }

    public void setMissed(boolean missed) {
        this.missed = missed;
    }

    public boolean isShot() {
        return shot;
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

    public int getFollowNumber() {
        return followNumber;
    }

    public void setFollowNumber(int followNumber) {
        this.followNumber = followNumber;
    }

    public boolean isMissed() {
        return missed;
    }
}
