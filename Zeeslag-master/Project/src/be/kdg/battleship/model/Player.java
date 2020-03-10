package be.kdg.battleship.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Player {

    protected Board board;


    private boolean won;
    private List<Ship> shipsToPlace;
    //TODO: naam,datum en beurten opslaan in txt bestand
    private String name;
    private Date date;
    public int turns;
    private Option options;

    public Player(Option option) {


        this.options = option;
        this.board = new Board(this.options);
        shipsToPlace = new LinkedList<>();
        for (int i = 2; i <= 5; i++) {
            shipsToPlace.add(new Ship(i, true));
        }
        this.name = null;
        this.won = false;
        this.turns = 0;


    }

    public void placeShip() {


    }
    public void fire(Player player){

    }

    public boolean placeShip(int x, int y, Ship ship) {
        if (placeAble(x, y, ship)) {
            System.out.println(ship.isHorizontal());
            int length = ship.getType();

            if (ship.isHorizontal()) {
                for (int i = y; i < y + length; i++) {
                    //Cell cell = getCell(x,i);
                    this.board.getMatrix()[x][i].setShip(ship);
                    this.board.getMatrix()[x][i].setType(ship.getType());


                }
                shipsToPlace.remove(ship);
            } else {
                for (int i = x; i < x + length; i++) {
                    //Cell cell = getCell(i,y);

                    this.board.getMatrix()[i][y].setShip(ship);
                    this.board.getMatrix()[x][i].setType(ship.getType());
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


    public List<Cell> getNeighbors(int x, int y) {
        //TODO: anders uitwerken

        List<Cell> neighbours = new ArrayList<>();
        System.out.println("x = " + x + " Y = " + y);
        NeighbourCell neighbourCell = new NeighbourCell(x + 1, y);
        if (isValidPoint(neighbourCell.getX(), neighbourCell.getY())) {
            Cell currentCell = board.getMatrix()[neighbourCell.getX()][neighbourCell.getY()];
            neighbours.add(currentCell);
            System.out.println("X neighbour = " + neighbourCell.getX() + " Y neighbour = " + neighbourCell.getY());
        }
        neighbourCell = new NeighbourCell(x - 1, y);
        if (isValidPoint(neighbourCell.getX(), neighbourCell.getY())) {
            Cell currentCell = board.getMatrix()[neighbourCell.getX()][neighbourCell.getY()];
            neighbours.add(currentCell);
            System.out.println("X neighbour = " + neighbourCell.getX() + " Y neighbour = " + neighbourCell.getY());
        }
        neighbourCell = new NeighbourCell(x, y + 1);
        if (isValidPoint(neighbourCell.getX(), neighbourCell.getY())) {
            Cell currentCell = board.getMatrix()[neighbourCell.getX()][neighbourCell.getY()];
            neighbours.add(currentCell);
            System.out.println("X neighbour = " + neighbourCell.getX() + " Y neighbour = " + neighbourCell.getY());
        }
        neighbourCell = new NeighbourCell(x, y - 1);
        if (isValidPoint(neighbourCell.getX(), neighbourCell.getY())) {
            Cell currentCell = board.getMatrix()[neighbourCell.getX()][neighbourCell.getY()];
            neighbours.add(currentCell);
            System.out.println("X neighbour = " + neighbourCell.getX() + " Y neighbour = " + neighbourCell.getY());
        }
        return neighbours;


    }


    public void fire(int x, int y, Player otherPlayer) {
        if (otherPlayer.board.getMatrix()[x][y].getShip() != null) {
            //Ship bijhouden voor type
            int type = otherPlayer.board.getMatrix()[x][y].getShip().getType();

            Ship temporaryShip = otherPlayer.board.getMatrix()[x][y].getShip();
            //Cell markeren net geschoten
            otherPlayer.board.getMatrix()[x][y].setShip(null);


            //Alle cellen checken
            for (Cell[] matrix : otherPlayer.board.getMatrix()) {
                for (Cell cell : matrix) {
                    if (cell.getShip() != null && cell.getShip().getType() == temporaryShip.getType()) { // equals ?
                        //cell.setMissed(false); //HIT
                        System.out.println("HIT");
                        otherPlayer.board.getMatrix()[x][y].setShot(true);
                        System.out.println(otherPlayer.board.getMatrix()[x][y].getType());
                        return;

                    }
                }
            }
            //TODO: ALERT sunken
            otherPlayer.board.getMatrix()[x][y].setShot(true);
            for (Cell[] matrix : otherPlayer.board.getMatrix()) {
                for (Cell cell : matrix) {
                    if (cell.getType() == type) {
                        cell.setSunken(true);
                    }
                }
            }


        } else {
            otherPlayer.board.getMatrix()[x][y].setMissed(true);
            System.out.println("MISS");//MISS

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

    public void setWon(boolean won) {
        this.won = won;
    }

    public String getName() {
        return name;
    }
}

