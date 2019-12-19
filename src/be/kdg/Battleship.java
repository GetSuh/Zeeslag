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

<<<<<<< HEAD
        System.out.println("Welcome to battleship!");

=======
>>>>>>> 71e689e1fccbef85a9f9afb16c4a05801b559dc7
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

<<<<<<< HEAD
        } while (!player1.checkLost() && !player2.checkLost()); // while true kan ook kijk naar turn methode...


=======
>>>>>>> 71e689e1fccbef85a9f9afb16c4a05801b559dc7
    }

    public void turn(Player player, Player otherPlayer) {

        int x;
        int y;
        System.out.println();
        System.out.printf("%s ", player.naam);

        System.out.println();
        do {
            System.out.println(" x coord:");
            x = scanner.nextInt();
            System.out.println(" y coord:");
            y = scanner.nextInt();
        } while (!otherPlayer.board.inRange(x, y));
        player.fire(x, y, otherPlayer);
        System.out.println("Your board");
        player.drawBoard(true);
        System.out.println("Enemy's board");
        otherPlayer.drawBoard(false);

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
<<<<<<< HEAD
                System.out.printf("Ship %d Horizontal?: ", i + 1);
                horizontal = scanner.nextBoolean();
                System.out.printf("x coord (0-9) ship %d: ", i + 1);
=======
                System.out.printf("Horizontal?(true/false): for ship %d",i+1);
                horizontal = scanner.nextBoolean();
                System.out.printf("x coord (0-9) ship %d: ",i+1);
>>>>>>> 71e689e1fccbef85a9f9afb16c4a05801b559dc7
                x = scanner.nextInt();
                System.out.printf("y coord(0-9) ship %d: ", i + 1);
                y = scanner.nextInt();

<<<<<<< HEAD
            } while (!player.board.inRange(x, y) || player.board.matrix[x][y] != null);
            player.placeShip(x, y, player.shipOnBoard.get(i),horizontal);
            player.drawBoard();


=======
            } while (!player.board.inRange(x, y) && player.board.matrix[x][y] != null);
            player.shipOnBoard.get(i).setHorizontal(horizontal);
            player.placeShip(x, y, player.shipOnBoard.get(i));
            player.drawBoard(true);
>>>>>>> 71e689e1fccbef85a9f9afb16c4a05801b559dc7
        }
    }
}
