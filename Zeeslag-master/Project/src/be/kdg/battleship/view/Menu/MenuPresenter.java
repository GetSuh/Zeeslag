package be.kdg.battleship.view.Menu;

import be.kdg.battleship.model.Battleship;
import be.kdg.battleship.view.PlacementView.PlacementPresenter;
import be.kdg.battleship.view.PlacementView.PlacementView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class MenuPresenter {
    private Battleship battleship;
    private MenuView menuView;

    public MenuPresenter(Battleship battleship, MenuView menuView) {
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
                PlacementPresenter placementPresenter = new PlacementPresenter(battleship,placementView);
                menuView.getScene().setRoot(placementView);
                //placementView.getScene().getWindow().sizeToScene();
                placementView.getScene().getWindow().setWidth(525);
                placementView.getScene().getWindow().setHeight(525);

            }
        });



    }

    private void updateView() {


    }
}
