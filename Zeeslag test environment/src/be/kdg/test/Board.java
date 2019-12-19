package be.kdg.test;

public class Board {

    public static final int WIDTH = 10;
    public static final int HEIGTH = 10;

    protected Ship [][] matrix;

    public Board() {
        this.matrix = new Ship[WIDTH][HEIGTH];
    }


    public boolean inRange(int x,int y){
        if (x < WIDTH && x >= 0 && y < HEIGTH && y >= 0){
            return true;
        }
        return false;

    }
}
