package be.kdg;

import java.util.LinkedList;
import java.util.List;

public class Player {
    protected String naam;
    protected Board board;
    protected List<Ship> shipOnBoard;


    public Player() {
<<<<<<< HEAD
=======


>>>>>>> 71e689e1fccbef85a9f9afb16c4a05801b559dc7
        this.board = new Board();
        shipOnBoard = new LinkedList<>();

        shipOnBoard.add(new Ship("Destroyer", true, 2));
        //shipOnBoard.add(new Ship("Above", true, 2));
        //shipOnBoard.add(new Ship("Ever", false, 2));

    }

<<<<<<< HEAD
    public void placeShip(int x, int y, Ship ship,boolean horizontal ) {
        ship.setHorizontal(horizontal);

=======
    public void placeShip(int x, int y, Ship ship) {
>>>>>>> 71e689e1fccbef85a9f9afb16c4a05801b559dc7
        if (board.inRange(x, y)) {
            if (!ship.horizontal) {
                for (int i = 0; i < ship.length; i++){

                    try {
                        if (board.inRange(x, y)) board.matrix[x + i][y] = ship;
                    } catch (IndexOutOfBoundsException ioobe) {
                        System.out.println("Ship does not fit!");
                        return;
                    }


                }

            } else {
                for (int i = 0; i < ship.length; i++) {
                    try {
                        if (board.inRange(x, y)) board.matrix[x][y + i] = ship;
                    } catch (IndexOutOfBoundsException ioobe) {
                        System.out.println("Ship does not fit!");
                    }
                }
            }
        }

        //board.matrix[x][y] = shipOnBoard.get(0);

    }

    public void fire(int x, int y, Player player) {
        if (player.board.matrix[x][y] != null) {
            Ship temporaryShip = player.board.matrix[x][y];

            Ship hit = new Ship("Hit", true, 1);
            hit.setHit(true);
            player.board.matrix[x][y] = hit;

            for (Ship ship[] : player.board.matrix) {
                for (Ship ship1 : ship) {

                    if (ship1 != null && ship1.getNaam().equalsIgnoreCase(temporaryShip.getNaam())) { // equals moet nog veranderen
                        System.out.println();
                        System.out.println("HIT");
                        return;
                    }

                }
            }
            System.out.println();
            System.out.println("SINK");

        } else {
            Ship miss = new Ship("Miss", true, 1);
            player.board.matrix[x][y] = miss;
            System.out.println();
            System.out.println("MISS");
        }
    }

    public void drawBoard(boolean show) {
        String spaties = new String("0");
        //String spaties1 = new String("1");

        for (Ship[] ship : board.matrix) {
            System.out.println();
            for (Ship ship1 : ship) {
                if (ship1 == null) {
                    System.out.print(String.format("%3s", spaties));
                } else if (ship1.isHit) System.out.print(String.format("%3s", ship1.toString()));
                else if (ship1.getNaam().equalsIgnoreCase("Miss"))
                    System.out.print(String.format("%3s", ship1.toString()));
<<<<<<< HEAD
                else if (ship1.placement)System.out.printf("%3s",ship1.toString());
=======
                else if (show) System.out.printf("%3s", ship1.toString());
>>>>>>> 71e689e1fccbef85a9f9afb16c4a05801b559dc7
                else System.out.print(String.format("%3s", spaties));

            }

        }
        System.out.println();

    }

    public boolean checkLost() {
        for (Ship[] ships : board.matrix) {
            for (Ship ship : ships) {
                if (ship != null && !ship.getNaam().equalsIgnoreCase("Hit") && !ship.getNaam().equalsIgnoreCase("Miss")) {
                    return false;
                }
            }
        }
        return true;

    }

    public void setNaam(String naam) {
        this.naam = naam;
    }
}

