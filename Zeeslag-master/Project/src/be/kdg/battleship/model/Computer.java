package be.kdg.battleship.model;

import java.util.List;
import java.util.Random;

public class Computer extends Player {


    private Cell firstCell;
    private Cell cellToRemember;

    private Random random;
    private Player player1;
    private Board smartBoard;


    public Computer(Option option) {
        super(option);
        player1 = new Player(option);
        random = new Random();
        smartBoard = new Board(option);

        firstCell = null;
        cellToRemember = null;

    }

    public void fire() {
        //TODO: Na hit , loopen over neighbour > 4 mogelijkheden > als hit dan alleen 2 mogelijkheden
        int x;
        int y;
        //Als er geen cell bestaat om verder te schieten dan random

        if (cellToRemember == null && firstCell == null) {

            do {
                x = roll(this.getBoard().matrix.length);
                y = roll(this.getBoard().matrix.length);
            } while (!player1.board.getMatrix()[x][y].isShot() && !player1.board.getMatrix()[x][y].isMissed());
            //!player1.board.getMatrix()[x][y].isShot() &&!player1.board.getMatrix()[x][y].isMissed()

            //TODO: CELL COORDINAAT BIHOUDEN
            firstCell = new Cell(x, y, this.smartBoard); // Cell bij houden van de eerste shot en bijhouden op een aparte bord.
            fire(x, y, player1); //FIRE
            //als eerste coordinaat raakt dan >
            if (player1.board.getMatrix()[x][y].isShot()) {
                List<Cell> listWithNeighbours = getNeighbors(x, y);
                //Opnieuw rollen over de  neighbours
                Cell cell2 = listWithNeighbours.get(roll(listWithNeighbours.size()));
                x = cell2.getX();
                y = cell2.getY();
                fire(x, y, player1);
                //TODO: Algoritme verder bijwerken
                //Als rechts van de cell geraakt is dan >


                if (player1.board.getMatrix()[x][y].isShot()) {//Na miss de andere 3 buren proberen schieten.

                    if (player1.board.getMatrix()[x][y].getX() > firstCell.getX() || player1.board.getMatrix()[x][y].getX() < firstCell.getX()) {

                        if (player1.getBoard().inRange(firstCell.getX() + 1, firstCell.getY())) {
                            //Cell bijhouden van andere kant van eerste geraakte cell
                            cellToRemember = new Cell(firstCell.getX() + 1, firstCell.getY(), this.smartBoard);
                            //blijven schieten in dezelfde richting
                            while (true) {
                                fire(++x, y, player1);

                                if (player1.board.getMatrix()[x][y].isSunken()) {
                                    firstCell = null;
                                    cellToRemember = null;
                                    fire();
                                    return;
                                    //nog een keer schieten op een random plaats.
                                }
                                if (!player1.getBoard().inRange(x+1, y)) {
                                    //andere kant
                                    fire();
                                    return;

                                }



                                if (player1.board.getMatrix()[x][y].isMissed()) {
                                    return;
                                }
                            }
                            //andere kant

                        } else{
                            fire();
                            return;
                        }

                    }//X--
                    //Y++
                    if (player1.board.getMatrix()[x][y].getY() > firstCell.getY() || player1.board.getMatrix()[x][y].getY() < firstCell.getY()) {
                        if (player1.getBoard().inRange(firstCell.getX(), firstCell.getY() + 1)) {
                            cellToRemember = new Cell(firstCell.getX(), firstCell.getY() + 1, this.smartBoard);
                            while (true) {
                                fire(x, ++y, player1);

                                if (player1.board.getMatrix()[x][y].isSunken()) {
                                    firstCell = null;
                                    cellToRemember = null;
                                    fire();
                                    return;
                                    //nog een keer schieten op een random plaats.
                                }
                                if (!player1.getBoard().inRange(x, y+1)) {
                                    //andere kant
                                    fire();
                                    return;

                                }

                                if (player1.board.getMatrix()[x][y].isMissed()) {
                                    return;
                                }
                            }
                        }
                        else {
                            fire();
                            return;
                        }
                    }
                }
            }
            else return;

        } else {
            x = cellToRemember.getX();
            y = cellToRemember.getY();
            if (firstCell.getX() > cellToRemember.getX() || firstCell.getX() < cellToRemember.getX()) {
                while (true) {
                    fire(--x, y, player1);
                    if (player1.board.getMatrix()[x][y].isSunken() || !player1.getBoard().inRange(x, y)) {
                        cellToRemember = null;
                        firstCell = null;
                        fire();
                        return;

                    }

                    if (player1.board.getMatrix()[x][y].isMissed()) {
                        return;

                    }
                }
            }
            if (firstCell.getY() > cellToRemember.getY() || firstCell.getY() < cellToRemember.getY() ) {
                while (true) {
                    fire(x, --y, player1);
                    if (player1.board.getMatrix()[x][y].isSunken() || !player1.getBoard().inRange(x, y)) {
                        cellToRemember = null;
                        firstCell = null;
                        fire();
                        return;

                    }

                    if (player1.board.getMatrix()[x][y].isMissed()) {
                        return;

                    }
                }
            }

        }
    }

    public void placeShip() {
        do {
            if (getShipsToPlace().get(0) != null) {
                boolean horizontal = random.nextBoolean();
                getShipsToPlace().get(0).setHorizontal(horizontal);
                placeShip(roll(this.getBoard().matrix.length), roll(this.getBoard().matrix.length), getShipsToPlace().get(0));
            }
        } while (getShipsToPlace().size() > 0);


    }

    public int roll(int bound) {
        return random.nextInt(bound);
    }


}
