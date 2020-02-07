package be.kdg.battleship.view;

import be.kdg.battleship.model.Battleship;

public class Handler {
    private Battleship battleship;
    private BattleshipView battleshipView;

    public Handler(Battleship battleship, BattleshipView battleshipView) {
        this.battleship = battleship;
        this.battleshipView = battleshipView;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {


    }

    private void updateView() {

    }
}
