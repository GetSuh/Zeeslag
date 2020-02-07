package be.kdg.zeeslag;

public class Board {


    public static final int WIDTH = 10;
    public static final int HEIGTH = 10;

    protected Ship [][] matrix;

    public Board() {
        this.matrix = new Ship[WIDTH][HEIGTH];
    }


    public boolean inRange(int x,int y){
        return x < WIDTH && x >= 0 && y < HEIGTH && y >= 0;

    }

}
