package be.kdg.battleship.model;

import java.util.ArrayList;

import java.util.LinkedList;
import java.util.List;

public class Player {

    protected Board board;
    private List<Ship> shipsToPlace;
    private String name;

    public int turns;
    private Option options;

    private Cell lastCell;
    private Ship lastShipPlaced;



    public Player(Option option) {


        this.options = option;
        this.board = new Board(this.options);
        shipsToPlace = new LinkedList<>();
        for (int i = 2; i <= 5; i++) {
            shipsToPlace.add(new Ship(i, true, i - 1));
        }

        //shipsToPlace.add(new Ship(2,true,1));
        //shipsToPlace.add(new Ship(3,true,2));

        lastCell = null;

        this.name = "no name";

        this.turns = 0;


    }

    public void placeShip() {
        //Polymorfisme


    }

    public void fire(Player player) {
        //Polymorfisme

    }

    public boolean placeShip(int x, int y, Ship ship) {
        if (placeAble(x, y, ship)) {

            int length = ship.getType();

            if (ship.isVertical()) {
                for (int i = y; i < y + length; i++) {
                    //Cell cell = getCell(x,i);
                    this.board.getMatrix()[x][i].setShip(ship);
                    this.board.getMatrix()[x][i].setType(ship.getType());
                    this.board.getMatrix()[x][i].setFollowNumber(ship.getFollowNumber());
                    this.lastShipPlaced = ship;


                }
                shipsToPlace.remove(ship);
            } else {
                for (int i = x; i < x + length; i++) {
                    //Cell cell = getCell(i,y);

                    this.board.getMatrix()[i][y].setShip(ship);
                    this.board.getMatrix()[i][y].setType(ship.getType());
                    this.board.getMatrix()[i][y].setFollowNumber(ship.getFollowNumber());
                    this.lastShipPlaced = ship;
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

        if (ship.isVertical()) {
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
        } else if (!ship.isVertical()) {
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


    public List<Cell> getNeighbors(int x, int y) {
        //TODO: anders uitwerken

        List<Cell> neighbours = new ArrayList<>();

        NeighbourCell neighbourCell = new NeighbourCell(x + 1, y);
        if (isValidPoint(neighbourCell.getX(), neighbourCell.getY())) {
            Cell currentCell = board.getMatrix()[neighbourCell.getX()][neighbourCell.getY()];
            neighbours.add(currentCell);

        }
        neighbourCell = new NeighbourCell(x - 1, y);
        if (isValidPoint(neighbourCell.getX(), neighbourCell.getY())) {
            Cell currentCell = board.getMatrix()[neighbourCell.getX()][neighbourCell.getY()];
            neighbours.add(currentCell);

        }
        neighbourCell = new NeighbourCell(x, y + 1);
        if (isValidPoint(neighbourCell.getX(), neighbourCell.getY())) {
            Cell currentCell = board.getMatrix()[neighbourCell.getX()][neighbourCell.getY()];
            neighbours.add(currentCell);

        }
        neighbourCell = new NeighbourCell(x, y - 1);
        if (isValidPoint(neighbourCell.getX(), neighbourCell.getY())) {
            Cell currentCell = board.getMatrix()[neighbourCell.getX()][neighbourCell.getY()];
            neighbours.add(currentCell);

        }
        return neighbours;


    }


    public void fire(int x, int y, Player otherPlayer) {
        if (otherPlayer.board.getMatrix()[x][y].getShip() != null) {
            //Ship bijhouden voor follownumber
            int followNumber = otherPlayer.board.getMatrix()[x][y].getShip().getFollowNumber();

            Ship temporaryShip = otherPlayer.board.getMatrix()[x][y].getShip();
            //Cell markeren net geschoten
            otherPlayer.board.getMatrix()[x][y].setShip(null);


            //Alle cellen checken
            for (Cell[] matrix : otherPlayer.board.getMatrix()) {
                for (Cell cell : matrix) {
                    if (cell.getShip() != null && cell.getShip().getFollowNumber() == temporaryShip.getFollowNumber()) { // equals ?
                        //cell.setMissed(false); //HIT

                        otherPlayer.board.getMatrix()[x][y].setShot(true);
                        lastCell = otherPlayer.board.getMatrix()[x][y];

                        return;

                    }
                }
            }

            otherPlayer.board.getMatrix()[x][y].setShot(true);
            for (Cell[] matrix : otherPlayer.board.getMatrix()) {
                for (Cell cell : matrix) {
                    if (cell.getFollowNumber() == followNumber) {
                        cell.setSunken(true);
                        lastCell = cell;
                    }
                }
            }


        } else {
            otherPlayer.board.getMatrix()[x][y].setMissed(true);
            lastCell =  otherPlayer.board.getMatrix()[x][y];


        }

    }


    public boolean isValidPoint(double x, double y) {
        return x >= 0 && x < options.getWidthBoard() && y >= 0 && y < options.getWidthBoard();
    }

    public List<Ship> getShipsToPlace() {
        return shipsToPlace;
    }

    public int getTurns() {
        return turns;
    }

    public Board getBoard() {
        return board;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public Cell getLastCell() {
        return lastCell;
    }

    public Ship getLastShipPlaced() {
        return lastShipPlaced;
    }
}

