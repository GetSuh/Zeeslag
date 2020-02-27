package be.kdg.battleship.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Computer extends Player {
    private Random random;
    private Player player1;

    public Computer() {
        super();
        random = new Random();
    }

    public boolean computerFire(){
        //TODO: Na hit , loopen over neighbour > 4 mogelijkheden > als hit dan alleen 2 mogelijkheden
        int x = roll();
        int y = roll();




        fire(x,y,player1);
        if (player1.board.getMatrix()[x][y].isWasShot()){
            List<Cell> listWithNeighbours = getNeighbors(x,y);
            fire(listWithNeighbours.get(random.nextInt(listWithNeighbours.size())).getX(),listWithNeighbours.get(random.nextInt(listWithNeighbours.size())).getY(),player1);

        }
        return true;
    }
    public void placeShipComputer(){
        do {
            if (getShipsToPlace().get(0) != null){
                placeShip(roll(),roll(),getShipsToPlace().get(0));
            }
        }while (getShipsToPlace().size()>0);

    }
    public int roll(){
        return random.nextInt(10);
    }


}
