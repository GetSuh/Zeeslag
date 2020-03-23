package be.kdg.battleship.view.MenuView;

import be.kdg.battleship.model.Battleship;
import be.kdg.battleship.model.Computer;
import be.kdg.battleship.view.OptionView.OptionPresenter;
import be.kdg.battleship.view.OptionView.OptionView;
import be.kdg.battleship.view.PlacementView.PlacementPresenter;
import be.kdg.battleship.view.PlacementView.PlacementView;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;


public class MenuPresenter {
    private Battleship model;
    private MenuView menuView;

    public MenuPresenter(Battleship model, MenuView menuView) {
        this.model = model;
        this.menuView = menuView;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {
        menuView.getIvPvCPU().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Computer computer = new Computer(model.options);
                model.setComputer(computer);
                model.player2.placeShip();






                PlacementView placementView = new PlacementView(model.options);
                PlacementPresenter placementPresenter = new PlacementPresenter(model,placementView);
                menuView.getScene().setRoot(placementView);
                //placementView.getScene().getWindow().sizeToScene();
                placementView.getScene().getWindow().setWidth(1280);
                placementView.getScene().getWindow().setHeight(720);
            }
        });


        menuView.getIvOptions().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                OptionView optionView = new OptionView();
                OptionPresenter optionPresenter = new OptionPresenter(model, optionView);
                menuView.getScene().setRoot(optionView);
                optionView.getScene().getWindow().setWidth(1280);
                optionView.getScene().getWindow().setHeight(720);
            }
        });

        menuView.getIvPvP().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                PlacementView placementView = new PlacementView(model.options);
                PlacementPresenter placementPresenter = new PlacementPresenter(model,placementView);
                menuView.getScene().setRoot(placementView);
                //placementView.getScene().getWindow().sizeToScene();
                placementView.getScene().getWindow().setWidth(1280);
                placementView.getScene().getWindow().setHeight(720);
            }
        });
        menuView.getIvExit().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.exit(0);
            }
        });

    }

    private void updateView() {


    }
}
