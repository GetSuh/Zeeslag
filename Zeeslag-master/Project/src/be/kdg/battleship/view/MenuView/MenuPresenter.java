package be.kdg.battleship.view.MenuView;

import be.kdg.battleship.model.Battleship;
import be.kdg.battleship.view.OptionView.OptionPresenter;
import be.kdg.battleship.view.OptionView.OptionView;
import be.kdg.battleship.view.PlacementView.PlacementPresenter;
import be.kdg.battleship.view.PlacementView.PlacementView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;


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
        menuView.getBtnOption().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                OptionView optionView = new OptionView();
                OptionPresenter optionPresenter = new OptionPresenter(battleship, optionView);
                menuView.getScene().setRoot(optionView);
                optionView.getScene().getWindow().setWidth(1280);
                optionView.getScene().getWindow().setHeight(720);

            }
        });



        menuView.getBtnStart().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                PlacementView placementView = new PlacementView();
                PlacementPresenter placementPresenter = new PlacementPresenter(battleship,placementView);
                menuView.getScene().setRoot(placementView);
                //placementView.getScene().getWindow().sizeToScene();
                placementView.getScene().getWindow().setWidth(1280);
                placementView.getScene().getWindow().setHeight(720);
            }
        });
        menuView.getIvPvP().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                PlacementView placementView = new PlacementView();
                PlacementPresenter placementPresenter = new PlacementPresenter(battleship,placementView);
                menuView.getScene().setRoot(placementView);
                //placementView.getScene().getWindow().sizeToScene();
                placementView.getScene().getWindow().setWidth(1280);
                placementView.getScene().getWindow().setHeight(720);
            }
        });





    }

    private void updateView() {


    }
}
