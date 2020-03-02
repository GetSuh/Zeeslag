package be.kdg.battleship.model;

import java.util.Random;
import java.util.Scanner;

public class Battleship {

    public Player player1;
    public Player player2;
    public Player currentPlayer;
    public Player otherPlayer;




    public Battleship() {
        this.player1 = new Player();
        this.player2 = new Player();
        currentPlayer = null;
        otherPlayer = null;

    }

    public void setPlayers(Player currentPlayer , Player otherPlayer) {
        this.currentPlayer = currentPlayer;
        this.otherPlayer = otherPlayer;
    }

    public void switchPlayer(){
        Player player = new Player();
        player = currentPlayer;
        currentPlayer = otherPlayer;
        otherPlayer = player;

    }

    public boolean checkWin(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (otherPlayer.getBoard().getMatrix()[i][j].getShip() != null){
                    return false;

                }

            }
        }
        return true;
    }
}
