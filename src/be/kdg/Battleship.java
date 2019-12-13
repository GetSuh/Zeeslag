package be.kdg;

public class Battleship {

    private boolean gameEnd;
    private Player player1;
    private Player player2;


    public Battleship(boolean gameEnd) {
        player1 = new Player();
        player2 = new Player();
        this.gameEnd = gameEnd;
    }

    public void start(){

        for (int i = 0; i < 6; i++) {
            player1.placeShip();

        }
        for (int i = 0; i < 6; i++) {
            player2.placeShip();
        }
        do {
            player2.drawBoard();
            player1.fire();

            player1.drawBoard();
            player2.fire();

        }while (!player1.shipOnBoard.isEmpty() || !player2.shipOnBoard.isEmpty());
        System.out.println("Game over");
    }
    /*
    TODO:Controle voor placeShip
         Controle na vuren
         Ship toString voor bord oplossing zoeken.
         gameLoop moet correct werken
         Lijst opvullen met de nodige schepen en de schepen moeten verwijdert worden uit de lijst als deze volledig gezonken is.
         Een betere oplossing voor het eindigen van het spel
         board.draw functie moet nog gemaakt worden


     */





}
