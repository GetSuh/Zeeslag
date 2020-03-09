package be.kdg.battleship.view.BattleshipCompView;

import be.kdg.battleship.model.Battleship;
import be.kdg.battleship.model.Computer;

public class BattleshipCompPresenter {
    private Battleship model;
    private BattleshipCompView view;

    public BattleshipCompPresenter(Battleship model, BattleshipCompView view) {
        this.model = model;
        this.view = view;
        model.setPlayers(model.player1,new Computer(model.options));
        addEventHandlers();
        updateView();


    }



    private void addEventHandlers() {


    }
    private void updateView() {

    }

}
