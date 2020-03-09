package be.kdg.battleship.model;

public class Board {
    private Option option;


    //public static final int WIDTH = 10;
    //public static final int HEIGTH = 10;


    public int ships = 5;

    protected Cell[][] matrix;

    public Board(Option option) {
        this.option = option;

        this.matrix = new Cell[this.option.getWidthBoard()][this.option.getWidthBoard()];
        for (int i = 0; i < this.option.getWidthBoard(); i++) {
            for (int j = 0; j < this.option.getWidthBoard(); j++) {
                matrix[i][j] = new Cell(i,j,this);
            }
        }
    }


    public boolean inRange(int x,int y){
        return x < this.option.getWidthBoard() && x >= 0 && y < this.option.getWidthBoard() && y >= 0;

    }

    public void setMatrix(Cell[][] matrix) {
        this.matrix = matrix;
        for (int i = 0; i < this.option.getWidthBoard(); i++) {
            for (int j = 0; j < this.option.getWidthBoard(); j++) {
                matrix[i][j] = new Cell(i,j,this);
            }
        }
    }

    public void setOption(Option option) {
        this.option = option;
    }

    public Cell[][] getMatrix() {
        return matrix;
    }
}
