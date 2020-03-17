package be.kdg.battleship.model;

public class Option {
    private static final int DEFAULT = 10;
    private static final int MAX = 20;
    public int widthBoard;
    private int shipsWantedToPlace;


    public Option() {
        this.widthBoard = DEFAULT;
    }

    public void setWidthBoard(int widthBoard) {

        //TODO: exception
        if (widthBoard > DEFAULT && widthBoard < MAX);
        this.widthBoard = widthBoard;
    }

    public int getWidthBoard() {
        return widthBoard;
    }

    public void setShipsWantedToPlace(int shipsWantedToPlace) {
        this.shipsWantedToPlace = shipsWantedToPlace;
    }
}
