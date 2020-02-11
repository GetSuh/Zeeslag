package be.kdg.test;

import java.util.LinkedList;
import java.util.List;

public class Player {
    protected Board board;
    protected List<Ship> shipOnBoard;
    protected Boolean isLost = false;


    public Player() {


        this.board = new Board();
        shipOnBoard = new LinkedList<>();

        shipOnBoard.add(new Ship("Destroyer", true, 2));
        shipOnBoard.add(new Ship("Above", true, 2));
        shipOnBoard.add(new Ship("Ever", true, 2));

    }

    public void placeShip(int x, int y, Ship ship) {

        if (board.inRange(x, y)) {
            if (!ship.horizontal) {
                for (int i = 0; i < ship.length; i++)
                    if (board.inRange(x, y)) board.matrix[x + i][y] = ship;
            } else {
                for (int i = 0; i < ship.length; i++) {
                    if (board.inRange(x, y)) board.matrix[x][y + i] = ship;
                }
            }
        }

        //board.matrix[x][y] = shipOnBoard.get(0);

    }

    public void fire(int x, int y,Player player) {
        if (player.board.matrix[x][y] != null) {
            Ship temporaryShip = player.board.matrix[x][y];
            player.board.matrix[x][y] = null;

            for (Ship ship[] : player.board.matrix) {
                for (Ship ship1 : ship) {

                    if (ship1 != null && ship1.naam == temporaryShip.naam) { // equals moet nog veranderen
                        System.out.println();
                        System.out.println("HIT");
                        return;
                    }

                }
            }
            System.out.println();
            System.out.println("SINK");

        } else{
            System.out.println();
            System.out.println("MISS");
        }


    }

    public void drawBoard() {
        String spaties = new String("0");
        String spaties1 = new String("1");

        for (Ship[] ship : board.matrix) {
            System.out.println();
            for (Ship ship1 : ship) {
                if (ship1 == null) {
                    System.out.print(String.format("%3s",spaties));
                } else System.out.print(String.format("%3s",spaties1));

            }

        }

    }

    public boolean checkLost() {
        for (Ship[] ships : board.matrix) {
            for (Ship ship : ships) {
                if (ship != null) {
                    return false;
                }
            }
        }
        return true;

    }


}
