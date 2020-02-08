package be.kdg.test;

import java.util.Scanner;

public class Battleship {
    private boolean gameEnd;
    private Player player1;
    private Player player2;
    private Scanner scanner = new Scanner(System.in);


    public Battleship(boolean gameEnd) {
        player1 = new Player();
        player2 = new Player();
        this.gameEnd = gameEnd;
    }

    public void start() {

        boolean lost = false;

        for (int i = 0; i < 3; i++) {
            player1.placeShip(0, 2*i,player1.shipOnBoard.get(i));

        }
        for (int i = 0; i < 3; i++) {
            player2.placeShip(0, 2*i,player2.shipOnBoard.get(i));
        }
        do {
            int x;
            int y;
            System.out.println("Player 1");
            player2.drawBoard();
            if (player2.checkLost()){
                System.out.println("Game over");
                System.exit(0);
            }

            player1.fire(0, 0,player2);
            player2.drawBoard();
            break;
            /*System.out.println("Player 2");
            player1.drawBoard();
            x = scanner.nextInt();
            y = scanner.nextInt();
            player2.fire(x, y);*/

        } while (!player2.checkLost() && !player1.checkLost());

    }
}
