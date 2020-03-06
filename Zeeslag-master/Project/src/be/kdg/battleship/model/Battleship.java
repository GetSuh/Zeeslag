package be.kdg.battleship.model;

import be.kdg.battleship.Option;

public class Battleship {

    public Player player1;
    public Player player2;
    public Player currentPlayer;
    public Player otherPlayer;
    public Option options;




    public Battleship() {
        options = new Option();
        this.player1 = new Player(this.options);
        this.player2 = new Player(this.options);
        currentPlayer = null;
        otherPlayer = null;


    }

    public void setPlayers(Player currentPlayer , Player otherPlayer) {
        this.currentPlayer = currentPlayer;
        this.otherPlayer = otherPlayer;
    }

    public void switchPlayer(){
        Player player = new Player(this.options);
        player = currentPlayer;
        currentPlayer = otherPlayer;
        otherPlayer = player;

    }

    public boolean checkWin(){
        for (int i = 0; i < options.getWidthBoard(); i++) {
            for (int j = 0; j < options.getWidthBoard(); j++) {
                if (otherPlayer.getBoard().getMatrix()[i][j].getShip() != null){
                    return false;

                }

            }
        }
        return true;
    }

    public Option getOptions() {
        return options;
    }
}
