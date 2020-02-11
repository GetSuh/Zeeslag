<<<<<<< HEAD:Project/src/be/kdg/Board.java
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
=======
package be.kdg.battleship.model;

public class Board {


    public static final int WIDTH = 10;
    public static final int HEIGTH = 10;

    protected Ship[][] matrix;

    public Board() {
        this.matrix = new Ship[WIDTH][HEIGTH];
    }


    public boolean inRange(int x,int y){
        return x < WIDTH && x >= 0 && y < HEIGTH && y >= 0;

    }

}
>>>>>>> 964809707590fbb87a6a4cfa8d47cc643b3e23de:Zeeslag/Zeeslag-master/Project/src/be/kdg/battleship/model/Board.java
