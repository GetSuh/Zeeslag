package be.kdg.battleship.model;

import javafx.geometry.Point2D;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Player {

    protected Board board;
    //TODO: shipsToPlace
    private List <Ship> shipsToPlace;



    public Player() {


        this.board = new Board();
        shipsToPlace = new LinkedList<>();
        for (int i = 1; i <= 5; i++) {
            shipsToPlace.add(new Ship(i,true));
        }


    }

    public boolean placeShip(int x, int y, Ship ship) {
        if (placeAble(x, y, ship)) {
            int length = ship.getType();

            if (ship.isHorizontal()){
                for (int i = y; i < y + length ; i++) {
                    //Cell cell = getCell(x,i);
                    this.board.getMatrix()[x][i].setShip(ship);

                }
            }
            else {
                for (int i = x; i < x+ length ; i++) {
                    //Cell cell = getCell(i,y);

                    this.board.getMatrix()[i][y].setShip(ship);
                }
            }
            return true;
        }
        return false;


        //board.matrix[x][y] = shipOnBoard.get(0);
    }
//TODO: placement methods
    public boolean placeAble(int x, int y, Ship ship) {
        int length = ship.getType();

        if (ship.isHorizontal()){
            for (int i = y; i <y + length ; i++) {
                if (!isValidPoint(x,i)){
                    return false;
                }
                Cell cell = getCell(x,i);
                if (cell.getShip() != null){
                    return false;
                }
                /*for (Cell neighbor : getNeighbors(i, y)) {
                    if (!isValidPoint(i, y))
                        return false;

                    if (neighbor.getShip() != null)
                        return false;
                }*/

            }
        }
        else if (!ship.isHorizontal()) {
            for (int i = x; i < x + length; i++) {
                if (!isValidPoint(i, y))
                    return false;

                Cell cell = board.matrix[i][y]; //getCell(i, y);
                if (cell.getShip() != null)
                    return false;

                /*for (Cell neighbor : getNeighbors(x, i)) {
                    if (!isValidPoint(x, i))
                        return false;

                    if (neighbor.getShip() != null)
                        return false;
                }*/
            }

        }
        return true;



    }
    public Cell getCell(int x ,int y){
        return board.getMatrix()[x][y];
    }
    //TODO: Neighbour methode anders uitwerken
    private Cell [] getNeighbors(int x,int y){
        Point2D[] points = new Point2D[] {
                new Point2D(x - 1, y),
                new Point2D(x + 1, y),
                new Point2D(x, y - 1),
                new Point2D(x, y + 1)
        };

        List<Cell> neighbors = new ArrayList<Cell>();

        for (Point2D p : points) {
            if (isValidPoint(p)) {
                neighbors.add(getCell((int)p.getX(), (int)p.getY()));
            }
        }

        return neighbors.toArray(new Cell[0]);
    }


    /*public void fire(int x, int y, Player player) {
        //if (player.board.matrix[x][y] == )
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
    }*/

    /*public void drawBoard(boolean show) {
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
                else if (show) System.out.printf("%3s", ship1.toString());
                else System.out.print(String.format("%3s", spaties));

            }

        }
        System.out.println();

    }*/

    /*public boolean checkLost() {
        for (Ship[] ships : board.matrix) {
            for (Ship ship : ships) {
                if (ship != null && !ship.getNaam().equalsIgnoreCase("Hit") && !ship.getNaam().equalsIgnoreCase("Miss")) {
                    return false;
                }
            }
        }
        return true;

    }*/

    /*public void setNaam(String naam) {
        this.naam = naam;
    }*/
    public boolean isValidPoint(double x,double y){
        return x >=0 && x < 10 && y >=0 && y < 10;
    }
    private boolean isValidPoint(Point2D point) {
        return isValidPoint(point.getX(), point.getY());
    }

    public List<Ship> getShipsToPlace() {
        return shipsToPlace;
    }

    public Board getBoard() {
        return board;
    }
}

