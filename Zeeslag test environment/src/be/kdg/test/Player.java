package be.kdg.test;

import java.util.LinkedList;

public class Player {


    protected Board board;
    protected Board logicBoard;
    protected LinkedList<Ship> shipLinkedList;


    public Player() {
        this.board = new Board();
        this.shipLinkedList = new LinkedList<>();
        this.logicBoard = new Board();
    }

    public void draw() {

    }

    public void update() {

    }

    public void setShip(int x, int y, Ship ship) {
        if (x < board.LENGTH && y < board.WIDTH) {
            if (!ship.horizontal) {
                for (int i = 0; i < ship.length; i++) {
                    board.matrix[x][y + 1] = ship;
                }
            } else {
                for (int i = 0; i < ship.length; i++) {
                    board.matrix[x + 1][y] = ship;
                }
            }
        }
    }
    public void fire(int x,int y){
        if (board.matrix[x][y] != null){


        }


    }
}
