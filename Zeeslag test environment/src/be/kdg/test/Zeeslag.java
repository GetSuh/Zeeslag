package be.kdg.test;

public class Zeeslag {

    private Player player1;
    private Player player2;

    private boolean gameLoop = false;

    public Zeeslag() {
        player1 = new Player();
        player2 = new Player();
    }
    public void start(){
        player1.draw();
        player2.draw();

    }

    public void end(){
        System.exit(0);
    }

    public static void main(String[] args) {
        Zeeslag zeeslag = new Zeeslag();
        zeeslag.start();




    }
}
