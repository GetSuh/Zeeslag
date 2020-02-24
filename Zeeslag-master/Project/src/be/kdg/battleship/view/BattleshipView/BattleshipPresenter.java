package be.kdg.battleship.view.BattleshipView;

import be.kdg.battleship.model.Battleship;
import be.kdg.battleship.view.EndScreenView.EndScreenPresenter;
import be.kdg.battleship.view.EndScreenView.EndScreenView;
import be.kdg.battleship.view.PlacementView.PlacementPresenter;
import be.kdg.battleship.view.PlacementView.PlacementView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BattleshipPresenter {
    private Battleship model;
    private BattleshipView view;

    public BattleshipPresenter(Battleship model, BattleshipView view) {
        this.model = model;
        this.view = view;
        model.setPlayers(model.player1,model.player2);
        addEventHandlers();
        updateView();
    }


    private void addEventHandlers() {
        view.getBtnFire().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int x = 0;
                int y = 0;
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        if (model.otherPlayer.getBoard().getMatrix()[i][j].isMarked()) {
                            x = model.otherPlayer.getBoard().getMatrix()[i][j].getX();
                            y = model.otherPlayer.getBoard().getMatrix()[i][j].getY();
                            model.currentPlayer.fire(x, y, model.otherPlayer);
                        }
                    }
                }
                updateView();
                //TODO: beurten
                if (model.otherPlayer.getBoard().getMatrix()[x][y].isMissed()){
                    model.switchPlayer();
                    updateView();
                }
                else {
                    if (model.checkWin()){
                        /*EndScreenView endScreenView = new EndScreenView();
                        EndScreenPresenter endScreenPresenter = new EndScreenPresenter(model,endScreenView);

                        view.getScene().setRoot(endScreenView);
                        //placementView.getScene().getWindow().sizeToScene();
                        endScreenView.getScene().getWindow().setWidth(1280);
                        endScreenView.getScene().getWindow().setHeight(720);*/


                    }
                }




            }
        });


        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                view.getRectangles()[i][j].setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        Rectangle rectangle = (Rectangle) mouseEvent.getSource();
                        int x = (int) rectangle.getX();
                        int y = (int) rectangle.getY();
                        for (int k = 0; k < 10; k++) {
                            for (int l = 0; l < 10; l++) {
                                if (model.otherPlayer.getBoard().getMatrix()[k][l].isMarked()) {
                                    model.otherPlayer.getBoard().getMatrix()[k][l].setMarked(false);
                                    //TODO: andere manier zoeken
                                    //view.getRectangles()[k][l].setFill(Color.BLACK);


                                }
                            }
                        }


                        model.otherPlayer.getBoard().getMatrix()[x][y].setMarked(true);
                        updateView();


                    }
                });
            }
        }
    }

    private void updateView() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (model.otherPlayer.getBoard().getMatrix()[i][j].isWasShot()) {
                    view.getRectangles()[i][j].setFill(Color.LIME);
                } else if (model.otherPlayer.getBoard().getMatrix()[i][j].isMissed()) {
                    view.getRectangles()[i][j].setFill(Color.PURPLE);
                } else if (model.otherPlayer.getBoard().getMatrix()[i][j].isMarked()) {
                    view.getRectangles()[i][j].setFill(Color.ORANGE);

                } else {
                    view.getRectangles()[i][j].setFill(Color.BLACK);
                }

            }
        }


    }


}
