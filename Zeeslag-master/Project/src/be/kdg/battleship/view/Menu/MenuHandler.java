package be.kdg.battleship.view.Menu;

import be.kdg.battleship.model.Battleship;
import be.kdg.battleship.view.PlacementView.PlacementHandler;
import be.kdg.battleship.view.PlacementView.PlacementView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class MenuHandler {
    private Battleship battleship;
    private MenuView menuView;

    public MenuHandler(Battleship battleship, MenuView menuView) {
        this.battleship = battleship;
        this.menuView = menuView;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {
        menuView.getBtnStart().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                PlacementView placementView = new PlacementView();
                PlacementHandler placementHandler = new PlacementHandler(battleship,placementView);
                menuView.getScene().setRoot(placementView);
                placementView.getScene().getWindow().sizeToScene();
                placementView.getScene().getWindow().setWidth(1920);
                placementView.getScene().getWindow().setHeight(1080);

            }
        });



    }

    private void updateView() {

    }
}
