package be.kdg.test;

import java.util.LinkedList;

public class Player {


    protected Board board;
    protected LinkedList<Ship> shipLinkedList;



    public Player() {
        this.board = new Board();
        this.shipLinkedList = new LinkedList<>();

    }

    public void draw() {

    }

    public boolean CheckWinCon() {
        if (shipLinkedList.isEmpty()){
            return true;
        }
        return false;
    }

    public void setShip(int x, int y, Ship ship) {
        if (board.inRange(x, y)) {
            if (!ship.horizontal) {
                for (int i = 0; i < ship.length; i++)
                    if (board.inRange(x, y)) board.matrix[x][y + 1] = ship;
            } else {
                for (int i = 0; i < ship.length; i++) {
                    if (board.inRange(x, y)) board.matrix[x + 1][y] = ship;
                }
            }
        }
    }
    public void fire(int x,int y){
        if (board.matrix[x][y] != null){
            Ship temporaryShip = board.matrix[x][y];
            board.matrix[x][y] = null;

            for (Ship ship[] : board.matrix) {
                for (Ship ship1 : ship) {
                    if (ship1 == temporaryShip){ // equals moet nog veranderen
                        System.out.println("HIT");
                        break;
                    }
                    else System.out.println("SINK");
                }
            }
        }
        else System.out.println("MISS");
    }
}
