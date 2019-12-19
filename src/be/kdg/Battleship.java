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

String string = new String("( ͡° ͜ʖ ͡°)");
        for (int i = 0; i < 6; i++) {
            System.out.print(string);
        }
        for (int i = 0; i < 5; i++) {
            System.out.printf("%-50s %s\n",string,string);
            if (i == 2) System.out.printf("%-25s %-24s %s\n",string,new String("Zeeslag"),string);
        }
        for (int i = 0; i < 7; i++) {
            System.out.print(string);
        }
        System.out.println();



        System.out.println("Naam player 1");
        String naam = scanner.nextLine();
        player1.setNaam(naam);
        System.out.println("Naam player 2");
        naam = scanner.nextLine();
        player2.setNaam(naam);

        placement(player1);
        placement(player2);


        do {
            turn(player1,player2);
            turn(player2,player1);

        } while (!player1.checkLost() && !player2.checkLost());



    }

    public void turn(Player player, Player otherPlayer) {

        int x;
        int y;
        System.out.println();
        System.out.printf("%s ",player.naam);

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
            System.out.printf("Game over,%s won the match!",player.naam);
            System.exit(0);
        }
    }
    public void placement(Player player){
        int x;
        int y;

        System.out.printf("%s ",player.naam);
        for (int i = 0; i < player.shipOnBoard.toArray().length; i++) {
            do {
                System.out.printf("x coord (0-9) ship %d: ",i+1);
                x = scanner.nextInt();
                System.out.printf("y coord(0-9) ship %d: ",i+1);
                y = scanner.nextInt();
            } while (!player.board.inRange(x, y) && player.board.matrix[x][y] != null);
            player.placeShip(x, y, player.shipOnBoard.get(i));


        }
    }
}
