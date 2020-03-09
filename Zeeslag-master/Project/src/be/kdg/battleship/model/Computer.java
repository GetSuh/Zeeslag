package be.kdg.battleship.model;

import java.util.List;
import java.util.Random;

public class Computer extends Player {

    private Cell cellToRemember;

    private Random random;
    private Player player1;
    private Board smartBoard;


    public Computer(Option option) {
        super(option);
        player1 = new Player(option);
        random = new Random();
        smartBoard = new Board(option);
    }

    public boolean computerFire() {
        //TODO: Na hit , loopen over neighbour > 4 mogelijkheden > als hit dan alleen 2 mogelijkheden
        int x = roll(this.getBoard().matrix.length);
        int y = roll(this.getBoard().matrix.length);
        //TODO: CELL COORDINAAT BIHOUDEN

        Cell firstCell = new Cell(x, y, this.smartBoard); // Cell bij houden van de eerste shot en bijhouden op een aparte bord.


        fire(x, y, player1); //FIRE


        if (player1.board.getMatrix()[x][y].isShot()) {
            List<Cell> listWithNeighbours = getNeighbors(x, y);
            x = listWithNeighbours.get(roll(listWithNeighbours.size())).getX();
            y = listWithNeighbours.get(roll(listWithNeighbours.size())).getY();
            fire(x, y, player1);
            //TODO: Algoritme verder bijwerken

            if (player1.board.getMatrix()[x][y].isShot() && player1.board.getMatrix()[x][y].getX() == firstCell.getX() + 1) {
                //Als recht van de cell geraakt is dan >
                cellToRemember = new Cell(firstCell.getX() - 1, firstCell.getY(), this.smartBoard);
                //Cell bijhouden van andere kant van eerste geraakte cell


            } else if (player1.board.getMatrix()[x][y].isShot() && player1.board.getMatrix()[x][y].getX() == firstCell.getX() - 1) {
                //Als links van de cell geraakt is dan >
            } else if (player1.board.getMatrix()[x][y].isShot() && player1.board.getMatrix()[x][y].getY() == firstCell.getY() + 1) {
                //Als bovenste cell geraakt is dan >

            } else if (player1.board.getMatrix()[x][y].isShot() && player1.board.getMatrix()[x][y].getY() == firstCell.getY() + 1) {
                //Als onderste cell geraakt is dan >

            } else return false;

        }
        return false;
    }

    public void placeShipComputer() {
        do {
            if (getShipsToPlace().get(0) != null) {
                placeShip(roll(this.getBoard().matrix.length), roll(this.getBoard().matrix.length), getShipsToPlace().get(0));
            }
        } while (getShipsToPlace().size() > 0);

    }

    public int roll(int bound) {
        return random.nextInt(bound);
    }


}
