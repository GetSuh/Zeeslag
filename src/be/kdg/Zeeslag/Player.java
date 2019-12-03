package be.kdg.Zeeslag;

public class Player {

    private boolean isEnemy;

    private Board board;
    private Board board2;


    public Player(boolean isEnemy, Board board , Board board2) {
        this.isEnemy = isEnemy;
        this.board = board;
        this.board2 = board2;


    }
}
