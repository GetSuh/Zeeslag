package be.kdg.battleship.view.EndScreenView;

import be.kdg.battleship.model.Battleship;
import be.kdg.battleship.view.MenuView.MenuPresenter;
import be.kdg.battleship.view.MenuView.MenuView;
import be.kdg.battleship.view.PlacementView.PlacementPresenter;
import be.kdg.battleship.view.PlacementView.PlacementView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class EndScreenPresenter {
    private Battleship model;
    private EndScreenView endScreenView;

    //CONSTRUCTOR


    public EndScreenPresenter(Battleship model, EndScreenView endScreenView) {
        this.model = model;
        this.endScreenView = endScreenView;
        addEventHandlers ();
        updateView();

    }

    private void updateView() {
        ////Informatie van view ophalen en doorsturen naar model.

    }

    private void addEventHandlers() {
        //Nodes van de view ophalen, en event erop zetten.
        endScreenView.getBtnMenu().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                /*PlacementView placementView = new PlacementView(model.options);
                PlacementPresenter placementPresenter = new PlacementPresenter(model,placementView);
                endScreenView.getScene().setRoot(placementView); // nieuwe scene wordt aangemaakt
                placementView.getScene().getWindow().setWidth(1600); // nieuwe scherm breedte en hoogte
                placementView.getScene().getWindow().setHeight(900);*/

                MenuView menuView = new MenuView();
                MenuPresenter menuPresenter = new MenuPresenter(new Battleship(),menuView);
                endScreenView.getScene().setRoot(menuView);
                menuView.getScene().getWindow().setWidth(1280);
                menuView.getScene().getWindow().setHeight(720);
            }
        }); {

        }

    }
}
