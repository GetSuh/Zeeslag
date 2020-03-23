package be.kdg.battleship.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Computer extends Player {


    private Cell firstCell;
    private Cell cellToRemember;
    private List<Cell> listWithNeighbours;
    private Random random;

    private Board smartBoard;

    public Computer(Option option) {
        super(option);
        listWithNeighbours = new ArrayList<>();

        random = new Random();
        smartBoard = new Board(option);

        firstCell = null;
        cellToRemember = null;
    }

    public void fire(Player player1) {
        //TODO: scenario shot 1 hit,shot 2 miss > buren
        //TODO: scenario 1ste 3 buren mist dan moet die juist schieten
        //TODO: na sink wordt cellToRemember niet null en probeert -- te doen terwijl 0-- buiten bord is


        int x;
        int y;


        //Als de computer geen cellen heeft die bijgehouden wordt dan schiet de computer random
        if (cellToRemember == null) {

            //roll als buren bestaan

            do {
                x = roll(this.getBoard().matrix.length);
                y = roll(this.getBoard().matrix.length);
            } while (player1.board.getMatrix()[x][y].isShot() || player1.board.getMatrix()[x][y].isMissed());


            // TODO: !player1.board.getMatrix()[x][y].isShot() &&!player1.board.getMatrix()[x][y].isMissed()

            //TODO: CELL COORDINAAT BIHOUDEN
            if (listWithNeighbours.isEmpty()) {
                //Buren kan alleen bestaan als er al geraakt is van de vorige schot
                fire(x, y, player1);
            }


            //als eerste coordinaat raakt of als de list al bestaat
            if (player1.board.getMatrix()[x][y].isShot() || !listWithNeighbours.isEmpty()) {

                //als de list nog niet bestond dan houden we de eerste geraakte cell bij en maken we een list van de buren
                if (listWithNeighbours.isEmpty()) {

                    listWithNeighbours = getNeighbors(x, y);
                    for (Iterator<Cell> iterator = listWithNeighbours.iterator(); iterator.hasNext(); ) {
                        Cell cell = iterator.next();
                        if (cell.isShot()) {
                            iterator.remove();
                        }
                    }

                    firstCell = new Cell(x, y, this.smartBoard); // Cell bij houden van de eerste shot en bijhouden op een aparte bord.

                }

                //Rollen over de buren en dan schieten

                //TODO: aanpassen

                Cell neighbour = listWithNeighbours.get(roll(listWithNeighbours.size()));
                x = neighbour.getX();
                y = neighbour.getY();
                fire(x, y, player1);
                //Als er nog maar 1 cell bestaat om te schieten en het het is 1 van de buren
                if (listWithNeighbours.size() == 1 && neighbour.getX() < firstCell.getX() || neighbour.getY() < firstCell.getY()) {
                    fire(neighbour.getX(), neighbour.getY(), player1);
                    listWithNeighbours.clear();
                    firstCell = null;
                    cellToRemember = null;
                    return;
                }

                //TODO: Algoritme verder bijwerken
                //Als we een buur raken dan
                if (player1.board.getMatrix()[x][y].isShot()) {//Na miss de andere 3 buren proberen schieten.
                    //Kijken in welke richting we moeten schieten door de coordinaten vergelijken die van de eerste cell
                    if (player1.board.getMatrix()[x][y].getX() > firstCell.getX() || player1.board.getMatrix()[x][y].getX() < firstCell.getX()) {
                        //Als er een verschil is tussen de X dan is het horizontaal
                        if (player1.getBoard().inRange(firstCell.getX() + 1, firstCell.getY())) {
                            //Kijken of we de cell kunnen bijhouden of het niet buiten het bord is
                            cellToRemember = new Cell(firstCell.getX() - 1, firstCell.getY(), this.smartBoard);
                            //Na het bijhouden moeten we de lijst met buren clearen
                            listWithNeighbours.clear();

                            //blijven schieten in dezelfde richting
                            while (true) {
                                fire(++x, y, player1);


                                if (player1.board.getMatrix()[x][y].isSunken()) {
                                    //Als sunken dan terug random schieten
                                    firstCell = null;
                                    cellToRemember = null;
                                    listWithNeighbours.clear();
                                    fire(player1); //nog een keer schieten op een random plaats.
                                    return;
                                }
                                if (!player1.getBoard().inRange(x + 1, y)) {
                                    fire(player1);//andere kant schieten
                                    return;
                                }

                                if (player1.board.getMatrix()[x][y].isMissed()) {
                                    return;
                                    //Andere kant
                                }
                            }

                        } else {

                            fire(player1);
                            return;
                        }

                    }//X--
                    //Y++
                    if (player1.board.getMatrix()[x][y].getY() > firstCell.getY() || player1.board.getMatrix()[x][y].getY() < firstCell.getY()) {
                        if (player1.getBoard().inRange(firstCell.getX(), firstCell.getY() + 1)) {
                            cellToRemember = new Cell(firstCell.getX(), firstCell.getY() - 1, this.smartBoard);
                            listWithNeighbours.clear();
                            while (true) {
                                fire(x, ++y, player1);

                                if (player1.board.getMatrix()[x][y].isSunken()) {
                                    firstCell = null;
                                    cellToRemember = null;
                                    listWithNeighbours.clear();
                                    fire(player1);
                                    return;
                                }
                                if (!player1.getBoard().inRange(x, y + 1)) {
                                    //andere kant+

                                    fire(player1);
                                    return;

                                }

                                if (player1.board.getMatrix()[x][y].isMissed()) {
                                    return;
                                }
                                if (player1.board.getMatrix()[x][y].isShot()) {
                                    fire(x, ++y, player1);

                                }
                            }
                        } else {
                            fire(player1);
                            return;

                        }
                    }
                } else {
                    listWithNeighbours.remove(neighbour);
                    return;
                }
            } else return;

        } else if (cellToRemember != null && firstCell != null) {

            x = cellToRemember.getX();
            y = cellToRemember.getY();

            if (cellToRemember.isShot()) {


                if (firstCell.getX() > x || firstCell.getX() < x) {
                    while (true) {
                        fire(x, y, player1);
                        if (player1.isValidPoint(x - 1, y)) {
                            x = x - 1;
                        }

                        if (player1.board.getMatrix()[x][y].isSunken() || !player1.getBoard().inRange(x, y)) {
                            cellToRemember = null;
                            firstCell = null;
                            listWithNeighbours.clear();
                            fire(player1);
                            return;

                        }

                        if (player1.board.getMatrix()[x][y].isMissed()) {
                            return;

                        }
                    }
                }
                if (firstCell.getY() > y || firstCell.getY() < y) {
                    while (true) {
                        fire(x, y, player1);
                        if (player1.isValidPoint(x, y - 1)) {
                            y = y - 1;
                        }
                        if (player1.board.getMatrix()[x][y].isSunken() || !player1.getBoard().inRange(x, y)) {
                            cellToRemember = null;
                            firstCell = null;
                            listWithNeighbours.clear();
                            fire(player1);
                            return;
                        }

                        if (player1.board.getMatrix()[x][y].isMissed()) {
                            return;

                        }
                    }
                }
            }

        }

    }

    public void placeShip() {
        do {
            if (getShipsToPlace().get(0) != null) {
                boolean horizontal = random.nextBoolean();
                getShipsToPlace().get(0).setVertical(horizontal);
                placeShip(roll(this.getBoard().matrix.length), roll(this.getBoard().matrix.length), getShipsToPlace().get(0));
            }
        } while (getShipsToPlace().size() > 0);


    }

    public int roll(int bound) {
        return random.nextInt(bound);
    }


}
