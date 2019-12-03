package be.kdg.Zeeslag;

import java.awt.*;

public class Cell {
    //EIGENSCHAPPEN
    private int x;
    private int y;
    private Color color;
    private Status status;
    //CONSTRUCTOR

    public Cell(int x, int y, Color color, Status status) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.status = status;
    }
    //METHODES

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
