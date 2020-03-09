package be.kdg.battleship.view.MenuView;

import be.kdg.battleship.model.Battleship;
import be.kdg.battleship.model.Computer;
import be.kdg.battleship.view.BattleshipCompView.BattleshipCompPresenter;
import be.kdg.battleship.view.BattleshipCompView.BattleshipCompView;
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
        menuView.getIvPvCPU().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Computer computer = new Computer(battleship.options);
                battleship.setComputer(computer);
                battleship.player2.placeShip();





                PlacementView placementView = new PlacementView(battleship.options);
                PlacementPresenter placementPresenter = new PlacementPresenter(battleship,placementView);
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
                OptionPresenter optionPresenter = new OptionPresenter(battleship, optionView);
                menuView.getScene().setRoot(optionView);
                optionView.getScene().getWindow().setWidth(1280);
                optionView.getScene().getWindow().setHeight(720);
            }
        });

        menuView.getIvPvP().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                PlacementView placementView = new PlacementView(battleship.options);
                PlacementPresenter placementPresenter = new PlacementPresenter(battleship,placementView);
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
