package be.kdg.Zeeslag;

import java.util.Arrays;
import java.util.LinkedList;

public class Board {
    //EIGENSCHAPPEN
    private static final int LENGTH = 10;
    private static final int HEIGTH = 10;

    private int length;
    private int heigth;
    private Player you;
    private Player enemy;

    private LinkedList<Ship> shipLinkedList;


    private int[][] area; //status
    private Cell [] coord;

    //CONSTRUCTOR

    public Board() {
        this.length = LENGTH;
        this.heigth = LENGTH;
        you = new Player(false,this,this);
        enemy = new Player(true,this,this);
        area = new int[length][heigth];
    }
    //METHODES
    public void draw(){
        for (int i = 0; i < length; i++) {
            System.out.print("\n");
            for (int j = 0; j < heigth; j++) {
                System.out.print(0);

            }
        }
    }


/*TODO:statussen van 0 tot 5
*   0 leeg
*   1 isBoot
*   2 magNietGeplaatstWorden
*   3 gemist
*   4 geraakt
*   5 volledigGeraakt*/

    public int giveStatus(int x , int y){
        return area[x][y];
    }

    @Override
    public String toString() {
        return "Board{" +
                "area=" + Arrays.toString(area) +
                '}';
    }
}
