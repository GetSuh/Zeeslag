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

    /*public void start() {

        System.out.println("Naam player 1");
        String naam = scanner.nextLine();
        player1.setNaam(naam);
        System.out.println("Naam player 2");
        naam = scanner.nextLine();
        player2.setNaam(naam);

        placement(player1);
        placement(player2);

        do {
            turn(player1, player2);
            turn(player2, player1);

        } while (!player1.checkLost() && !player2.checkLost());

    }*/

    /*public void turn(Player player, Player otherPlayer) {

        int x;
        int y;
        int aantalIteraties = 0;
        System.out.println();
        System.out.printf("%s ", player.naam);

        System.out.println();


        System.out.printf("%s's board",otherPlayer.naam);
        otherPlayer.drawBoard(false);
        System.out.println();
        System.out.printf("%s's board",player.naam);
        player.drawBoard(true);
        do {

            if (aantalIteraties > 0){
                System.out.println("OUT OF BOUNDARY");
            }

            System.out.println(" x coord:");
            x = scanner.nextInt();
            System.out.println(" y coord:");
            y = scanner.nextInt();
            aantalIteraties++;
        } while (!otherPlayer.board.inRange(x, y));



        player.fire(x, y, otherPlayer);

        System.out.printf("%s's board",otherPlayer.naam);
        otherPlayer.drawBoard(false);
        System.out.println();
        System.out.printf("%s's board",player.naam);
        player.drawBoard(true);

        if (otherPlayer.checkLost()) {
            System.out.println();
            System.out.printf("Game over,%s won the match!", player.naam);
            System.exit(0);
        }
    }*/

    /*public void placement(Player player) {
        int x;
        int y;
        boolean horizontal;


        System.out.printf("%s ", player.naam);
        for (int i = 0; i < player.shipOnBoard.toArray().length; i++) {

            do {
                System.out.printf("Horizontal?(true/false): for ship %d (%d long)", i + 1,player.shipOnBoard.get(i).length);
                horizontal = scanner.nextBoolean();
                System.out.printf("x coord (0-9) ship %d: ", i + 1);
                x = scanner.nextInt();
                System.out.printf("y coord(0-9) ship %d: ", i + 1);
                y = scanner.nextInt();

            } while (!player.placeAble(x, y, player.shipOnBoard.get(i)));
            player.shipOnBoard.get(i).setHorizontal(horizontal);


            player.placeShip(x, y, player.shipOnBoard.get(i));

            player.drawBoard(true);
        }
    }*/
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
