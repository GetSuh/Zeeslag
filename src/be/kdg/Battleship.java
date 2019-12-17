package be.kdg;

import java.util.Random;
import java.util.Scanner;

public class Battleship {

    private Player player1;
    private Player player2;
    private Scanner scanner = new Scanner(System.in);


    public Battleship() {
        player1 = new Player();
        player2 = new Player();

    }

    public void start() {
        Random random = new Random();

        for (int i = 0; i < player1.shipOnBoard.toArray().length; i++) {
            player1.placeShip(random.nextInt(10), random.nextInt(10), player1.shipOnBoard.get(i));

        }
        for (int i = 0; i < player2.shipOnBoard.toArray().length; i++) {
            player2.placeShip(0, 0, player2.shipOnBoard.get(i));
        }
        do {
            int x;
            int y;
            System.out.println();
            System.out.println("Player 1");

            player2.drawBoard();
            System.out.println();


            do {
                System.out.println("x waarde:");
                x = scanner.nextInt();
                System.out.println("y waarde:");
                y = scanner.nextInt();
            }while (!player1.board.inRange(x,y));



            player1.fire(x, y, player2);
            if (player2.checkLost()) {
                player2.drawBoard();
                System.out.println();
                System.out.println("Game over");
                System.exit(0);
            }




            /*System.out.println("Player 2");
            player1.drawBoard();
            x = scanner.nextInt();
            y = scanner.nextInt();
            player2.fire(x, y);*/

        } while (!player2.checkLost() && !player1.checkLost());
        System.out.println();
        System.out.println("Game over");

    }
}
