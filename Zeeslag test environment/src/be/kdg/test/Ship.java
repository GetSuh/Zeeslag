package be.kdg.test;

public class Ship {
    protected String kleur;
    protected boolean horizontal;
    protected int length;

    public Ship(boolean horizontal, int length) {
        this.horizontal = horizontal;
        this.length = length;
    }
}
