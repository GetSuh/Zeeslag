package be.kdg.battleship.model;

public class Board {


    public static final int WIDTH = 10;
    public static final int HEIGTH = 10;

    public int ships = 5;

    protected Cell[][] matrix;

    public Board() {
        this.matrix = new Cell[WIDTH][HEIGTH];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                matrix[i][j] = new Cell(i,j,this);
            }
        }
    }


    public boolean inRange(int x,int y){
        return x < WIDTH && x >= 0 && y < HEIGTH && y >= 0;

    }

    public Cell[][] getMatrix() {
        return matrix;
    }
}
