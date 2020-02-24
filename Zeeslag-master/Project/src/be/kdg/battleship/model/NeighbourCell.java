package be.kdg.battleship.model;

public class NeighbourCell {
    private int x;
    private int y;

    public NeighbourCell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
