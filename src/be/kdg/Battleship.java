package be.kdg;

import java.util.Random;
import java.util.Scanner;

public class Battleship {

    private Player player1;
    private Player player2;
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();


    public Battleship() {
        player1 = new Player();
        player2 = new Player();

    }

    public void start() {

        System.out.println("Welcome to battleship!");

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

        } while (!player1.checkLost() && !player2.checkLost()); // while true kan ook kijk naar turn methode...


    }

    public void turn(Player player, Player otherPlayer) {

        int x;
        int y;
        System.out.println();
        System.out.printf("%s ", player.naam);

        otherPlayer.drawBoard();
        System.out.println();
        do {
            System.out.println(" x coord:");
            x = scanner.nextInt();
            System.out.println(" y coord:");
            y = scanner.nextInt();
        } while (!otherPlayer.board.inRange(x, y));

        player.fire(x, y, otherPlayer);
        otherPlayer.drawBoard();
        if (otherPlayer.checkLost()) {
            System.out.println();
            System.out.printf("Game over,%s won the match!", player.naam);
            System.exit(0);
        }
    }

    public void placement(Player player) {
        int x;
        int y;
        boolean horizontal;

        System.out.printf("%s ", player.naam);
        for (int i = 0; i < player.shipOnBoard.toArray().length; i++) {
            do {
                System.out.printf("Ship %d Horizontal?: ", i + 1);
                horizontal = scanner.nextBoolean();
                System.out.printf("x coord (0-9) ship %d: ", i + 1);
                x = scanner.nextInt();
                System.out.printf("y coord(0-9) ship %d: ", i + 1);
                y = scanner.nextInt();

            } while (!player.board.inRange(x, y) || player.board.matrix[x][y] != null);
            player.placeShip(x, y, player.shipOnBoard.get(i),horizontal);
            player.drawBoard();


        }
    }
}
