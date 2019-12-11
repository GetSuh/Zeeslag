package be.kdg.test;

public class Board {

    public static final int LENGTH = 10;
    public static final int WIDTH = 10;


    protected Ship [][] matrix;

    public Board() {
        this.matrix = new Ship[LENGTH][WIDTH];
    }


    public boolean inRange(int x,int y){
        if (x < LENGTH && x > 0 && y < WIDTH && y > 0){
            return true;
        }
        return false;

    }



}
