package be.kdg.battleship.view.PlacementView;

import be.kdg.battleship.model.Battleship;
import be.kdg.battleship.view.Menu.MenuView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class PlacementHandler {
    private Battleship battleship;
    private PlacementView placementView;

    public PlacementHandler(Battleship battleship, PlacementView placementView) {
        this.battleship = battleship;
        this.placementView = placementView;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {



    }

    private void updateView() {

    }
}
