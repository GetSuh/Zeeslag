package be.kdg.battleship.view.EndScreenView;

import be.kdg.battleship.model.Battleship;
import be.kdg.battleship.view.MenuView.MenuPresenter;
import be.kdg.battleship.view.MenuView.MenuView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;

public class EndScreenPresenter {
    private Battleship model;
    private EndScreenView view;

    //CONSTRUCTOR


    public EndScreenPresenter(Battleship model, EndScreenView view) {
        this.model = model;
        this.view = view;
        addEventHandlers ();
        updateView();

    }

    private void updateView() {
        ////Informatie van view ophalen en doorsturen naar model.
        for (int i = 0; i < model.options.getWidthBoard(); i++) {
            for (int j = 0; j < model.options.getWidthBoard(); j++) {
                if (model.currentPlayer.getBoard().getMatrix()[i][j].isSunken()){
                    view.getVictoryBoard().getRectangles()[i][j].setFill(Color.RED);
                }
                else if (model.currentPlayer.getBoard().getMatrix()[i][j].isShot()){
                    view.getVictoryBoard().getRectangles()[i][j].setFill(Color.LIME);
                }
                else if (model.currentPlayer.getBoard().getMatrix()[i][j].isMissed()) {
                    view.getVictoryBoard().getRectangles()[i][j].setFill(Color.PURPLE);
                    System.out.println("x" +i);
                    System.out.println("y"+j);
                }
                else if (model.currentPlayer.getBoard().getMatrix()[i][j].getShip() != null){
                    view.getVictoryBoard().getRectangles()[i][j].setFill(Color.GOLD);


                }
                else {
                    view.getVictoryBoard().getRectangles()[i][j].setFill(Color.BLACK);

                }
            }
        }
        for (int i = 0; i < model.options.getWidthBoard(); i++) {
            for (int j = 0; j < model.options.getWidthBoard(); j++) {
                if (model.otherPlayer.getBoard().getMatrix()[i][j].isSunken()){
                    view.getDefeatBoard().getRectangles()[i][j].setFill(Color.RED);
                }
                else if (model.otherPlayer.getBoard().getMatrix()[i][j].isShot()){
                    view.getDefeatBoard().getRectangles()[i][j].setFill(Color.LIME);
                }
                else if (model.otherPlayer.getBoard().getMatrix()[i][j].isMissed()) {
                    view.getDefeatBoard().getRectangles()[i][j].setFill(Color.PURPLE);
                    System.out.println("x" +i);
                    System.out.println("y"+j);
                }
                else if (model.otherPlayer.getBoard().getMatrix()[i][j].getShip() != null){
                    view.getDefeatBoard().getRectangles()[i][j].setFill(Color.GOLD);
                }
                else {
                    view.getDefeatBoard().getRectangles()[i][j].setFill(Color.BLACK);

                }
            }
        }




    }

    private void addEventHandlers() {
        //Nodes van de view ophalen, en event erop zetten.
        view.getBtnMenu().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                /*PlacementView placementView = new PlacementView(model.options);
                PlacementPresenter placementPresenter = new PlacementPresenter(model,placementView);
                endScreenView.getScene().setRoot(placementView); // nieuwe scene wordt aangemaakt
                placementView.getScene().getWindow().setWidth(1600); // nieuwe scherm breedte en hoogte
                placementView.getScene().getWindow().setHeight(900);*/

                MenuView menuView = new MenuView();
                MenuPresenter menuPresenter = new MenuPresenter(new Battleship(),menuView);
                view.getScene().setRoot(menuView);
                menuView.getScene().getWindow().setWidth(1280);
                menuView.getScene().getWindow().setHeight(720);
            }
        }); {

        }

    }
}
