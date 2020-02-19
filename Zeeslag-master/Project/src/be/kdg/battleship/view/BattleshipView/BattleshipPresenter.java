package be.kdg.battleship.view.BattleshipView;

import be.kdg.battleship.model.Battleship;

public class BattleshipPresenter {
    private Battleship model;
    private BattleshipView view;

    public BattleshipPresenter(Battleship model, BattleshipView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();
    }

    private void updateView() {

    }

    private void addEventHandlers() {
    }
}
