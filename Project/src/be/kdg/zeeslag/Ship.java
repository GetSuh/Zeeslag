package be.kdg.zeeslag;

public class Ship {

    protected boolean isHit = false;
    private String naam;
    protected boolean horizontal;
    protected int length;
    protected boolean placement;



    public Ship(String naam, boolean horizontal, int length) {
        this.naam = naam;
        this.horizontal = horizontal;
        this.length = length;

    }

    @Override
    public String toString() {
        return String.format("%c",naam.charAt(0));
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

    public String getNaam() {
        return naam;
    }

    public void setPlacement(boolean placement) {
        this.placement = placement;
    }
}
