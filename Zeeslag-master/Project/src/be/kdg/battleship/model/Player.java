package be.kdg.battleship.model;

import javafx.geometry.Point2D;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Player {

    protected Board board;
    private List<Ship> shipsToPlace;


    public Player() {


        this.board = new Board();
        shipsToPlace = new LinkedList<>();
        for (int i = 1; i <= 5; i++) {
            shipsToPlace.add(new Ship(i, true));
        }


    }

    public boolean placeShip(int x, int y, Ship ship) {
        if (placeAble(x, y, ship)) {
            int length = ship.getType();

            if (ship.isHorizontal()) {
                for (int i = y; i < y + length; i++) {
                    //Cell cell = getCell(x,i);
                    this.board.getMatrix()[x][i].setShip(ship);

                }
                shipsToPlace.remove(ship);
            } else {
                for (int i = x; i < x + length; i++) {
                    //Cell cell = getCell(i,y);

                    this.board.getMatrix()[i][y].setShip(ship);
                }
                shipsToPlace.remove(ship);
            }
            return true;

        }
        return false;


        //board.matrix[x][y] = shipOnBoard.get(0);
    }

    public boolean placeAble(int x, int y, Ship ship) {
        int length = ship.getType();

        if (ship.isHorizontal()) {
            for (int i = y; i < y + length; i++) {
                if (!isValidPoint(x, i)) {
                    return false;
                }
                Cell cell = getCell(x, i);
                if (cell.getShip() != null) {
                    return false;
                }
                for (Cell neighbor : getNeighbors(x, i)) {
                    if (!isValidPoint(x, i))
                        return false;

                    if (neighbor.getShip() != null)
                        return false;
                }

            }
        } else if (!ship.isHorizontal()) {
            for (int i = x; i < x + length; i++) {
                if (!isValidPoint(i, y))
                    return false;

                Cell cell = board.matrix[i][y]; //getCell(i, y);
                if (cell.getShip() != null)
                    return false;

                for (Cell neighbor : getNeighbors(i, y)) {
                    if (!isValidPoint(i, y))
                        return false;

                    if (neighbor.getShip() != null)
                        return false;
                }
            }

        }
        return true;


    }

    public Cell getCell(int x, int y) {
        return board.getMatrix()[x][y];
    }

    //TODO: Neighbour methode anders uitwerken
    /*private Cell [] getNeighbors(int x,int y){
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
    }*/
    public Cell[] getNeighbors(int x, int y) {
        //TODO: Deze methode refactoren naar een andere Class

        List<Cell> neighbours = new ArrayList<>();
        System.out.println("x = " + x + " Y = " + y);
        NeighbourCell neighbourCell = new NeighbourCell(x +1,y);
        if (isValidPoint(neighbourCell.getX(),neighbourCell.getY())){
            Cell currentCell = board.getMatrix()[neighbourCell.getX()][neighbourCell.getY()];
            neighbours.add(currentCell);
            System.out.println("X neighbour = " + neighbourCell.getX() + " Y neighbour = "+ neighbourCell.getY());
        }
        neighbourCell = new NeighbourCell(x -1,y);
        if (isValidPoint(neighbourCell.getX(),neighbourCell.getY())){
            Cell currentCell = board.getMatrix()[neighbourCell.getX()][neighbourCell.getY()];
            neighbours.add(currentCell);
            System.out.println("X neighbour = " + neighbourCell.getX() + " Y neighbour = "+ neighbourCell.getY());
        }
        neighbourCell = new NeighbourCell(x,y+1);
        if (isValidPoint(neighbourCell.getX(),neighbourCell.getY())){
            Cell currentCell = board.getMatrix()[neighbourCell.getX()][neighbourCell.getY()];
            neighbours.add(currentCell);
            System.out.println("X neighbour = " + neighbourCell.getX() + " Y neighbour = "+ neighbourCell.getY());
        }
        neighbourCell = new NeighbourCell(x,y-1);
        if (isValidPoint(neighbourCell.getX(),neighbourCell.getY())){
            Cell currentCell = board.getMatrix()[neighbourCell.getX()][neighbourCell.getY()];
            neighbours.add(currentCell);
            System.out.println("X neighbour = " + neighbourCell.getX() + " Y neighbour = "+ neighbourCell.getY());
        }
        return  neighbours.toArray(new Cell[0]);


    }


    public void fire(int x, int y, Player otherPlayer) {
        if (otherPlayer.board.getMatrix()[x][y].getShip() != null) {
            //Ship bijhouden voor type
            Ship temporaryShip = otherPlayer.board.getMatrix()[x][y].getShip();
            //Cell markeren net geschoten
            otherPlayer.board.getMatrix()[x][y].setShip(null);


            //Alle cellen checken
            for (Cell[] matrix : otherPlayer.board.getMatrix()) {
                for (Cell cell : matrix) {
                    if (cell.getShip() != null && cell.getShip().getType() == temporaryShip.getType()) { // equals ?
                        //cell.setMissed(false); //HIT
                        System.out.println("HIT");
                        otherPlayer.board.getMatrix()[x][y].setWasShot(true);
                        return;

                    }
                }
            }
            System.out.println("Sink");// aparte gif voor sink
            otherPlayer.board.getMatrix()[x][y].setWasShot(true);

        } else {
            otherPlayer.board.getMatrix()[x][y].setMissed(true);
            System.out.println("MISS");//MISS

        }

    }

    public boolean isValidPoint(double x, double y) {
        return x >= 0 && x < 10 && y >= 0 && y < 10;
    }

    public List<Ship> getShipsToPlace() {
        return shipsToPlace;
    }

    public Board getBoard() {
        return board;
    }
}

