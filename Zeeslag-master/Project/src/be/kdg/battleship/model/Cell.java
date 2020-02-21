package be.kdg.battleship.model;

public class Cell {
    private int x;
    private int y;
    private Ship ship = null;
    private boolean wasShot;
    private boolean marked;
    private boolean missed;

    private Board board;



    public Cell(int x, int y, Board board) {
        this.x = x;
        this.y = y;
        this.board = board;
        //this.ship = null;
        this.missed = true;

        this.wasShot = false;
        this.marked = false;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
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

    public boolean isMarked() {
        return marked;
    }

    public boolean isMissed() {
        return missed;
    }
}
