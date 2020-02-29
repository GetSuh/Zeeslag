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
        int x = roll(this.getBoard().matrix.length);
        int y = roll(this.getBoard().matrix.length);
        //TODO: CELL COORDINAAT BIHOUDEN

        Cell cell;


        fire(x,y,player1); //FIRE
        cell = new Cell(x,y,this.board);



        if (player1.board.getMatrix()[x][y].isWasShot()){
            List<Cell> listWithNeighbours = getNeighbors(x,y);
            x = listWithNeighbours.get(roll(listWithNeighbours.size())).getX();
            y = listWithNeighbours.get(roll(listWithNeighbours.size())).getY();
            fire(x,y,player1);
            if (player1.board.getMatrix()[x][y].isWasShot()){

            }




        }
        return true;
    }
    public void placeShipComputer(){
        do {
            if (getShipsToPlace().get(0) != null){
                placeShip(roll(this.getBoard().matrix.length),roll(this.getBoard().matrix.length),getShipsToPlace().get(0));
            }
        }while (getShipsToPlace().size()>0);

    }
    public int roll(int bound){
        return random.nextInt(bound);
    }


}
