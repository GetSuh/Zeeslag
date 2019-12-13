package be.kdg;

public class Ship {

    protected boolean isHit = false;
    protected String naam;
    protected boolean horizontal;
    protected int length;

    public Ship(String naam, boolean horizontal, int length) {
        this.naam = naam;
        this.horizontal = horizontal;
        this.length = length;

    }

    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }

    public void setHit(boolean hit) {
        isHit = hit;
    }

    public boolean isHit() {
        return isHit;
    }
}
