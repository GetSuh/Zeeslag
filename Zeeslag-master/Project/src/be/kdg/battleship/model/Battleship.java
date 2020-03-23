package be.kdg.battleship.model;

import javax.imageio.IIOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
                if (player2 instanceof Computer){
                    if (player2.getBoard().getMatrix()[i][j].getShip() != null){
                        return false;
                    }
                }
                if (otherPlayer.getBoard().getMatrix()[i][j].getShip() != null){

                    return false;

                }



            }
        }
        return true;

    }
    public void setComputer(Computer computer){
        this.player2 = computer;
    }


    public Option getOptions() {
        return options;
    }

    public void writeScores() throws IOException {

        BufferedWriter writer = new BufferedWriter(
                new FileWriter("resources/logfile.txt", true)  //Set true for append mode
        );
        writer.newLine();   //Add new line
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime localDateTime = LocalDateTime.now();
        String tekst = currentPlayer.getName() + " Turns: " + currentPlayer.turns + " " + dtf.format(localDateTime);
        writer.write(tekst);
        writer.close();

    }
}
