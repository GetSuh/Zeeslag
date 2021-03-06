package be.kdg.battleship.view.BattleshipView;

import be.kdg.battleship.model.Battleship;
import be.kdg.battleship.view.EndScreenView.EndScreenPresenter;
import be.kdg.battleship.view.EndScreenView.EndScreenView;
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
        view.getImgFire().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                int x = 0;
                int y = 0;
                for (int i = 0; i < model.options.getWidthBoard(); i++) {
                    for (int j = 0; j < model.options.getWidthBoard(); j++) {
                        if (model.otherPlayer.getBoard().getMatrix()[i][j].isMarked() && !model.otherPlayer.getBoard().getMatrix()[i][j].isMissed() ) {
                            x = model.otherPlayer.getBoard().getMatrix()[i][j].getX();
                            y = model.otherPlayer.getBoard().getMatrix()[i][j].getY();
                            model.currentPlayer.fire(x, y, model.otherPlayer);
                        }
                    }
                }
                updateView();
                if (model.otherPlayer.getBoard().getMatrix()[x][y].isMissed()){
                    model.currentPlayer.turns++;
                    model.switchPlayer();
                    updateView();
                }
                else {
                    if (model.checkWin()){
                        EndScreenView endScreenView = new EndScreenView(model.options);
                        EndScreenPresenter endScreenPresenter = new EndScreenPresenter(model,endScreenView);

                        view.getScene().setRoot(endScreenView);
                        //placementView.getScene().getWindow().sizeToScene();
                        endScreenView.getScene().getWindow().setWidth(1280);
                        endScreenView.getScene().getWindow().setHeight(720);


                    }
                }

            }
        });


        for (int i = 0; i < model.options.getWidthBoard(); i++) {
            for (int j = 0; j < model.options.getWidthBoard(); j++) {
                view.getRectangles()[i][j].setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        Rectangle rectangle = (Rectangle) mouseEvent.getSource();
                        int x = (int) rectangle.getX();
                        int y = (int) rectangle.getY();
                        for (int k = 0; k < model.options.getWidthBoard(); k++) {
                            for (int l = 0; l < model.options.getWidthBoard(); l++) {
                                if (model.otherPlayer.getBoard().getMatrix()[k][l].isMarked()) {
                                    model.otherPlayer.getBoard().getMatrix()[k][l].setMarked(false);
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
        for (int i = 0; i < model.options.getWidthBoard(); i++) {
            for (int j = 0; j < model.options.getWidthBoard(); j++) {
                if (model.otherPlayer.getBoard().getMatrix()[i][j].isSunken()){
                    view.getRectangles()[i][j].setFill(Color.RED);

                }
                else if (model.otherPlayer.getBoard().getMatrix()[i][j].isShot()){
                    view.getRectangles()[i][j].setFill(Color.LIME);
                }
                else if (model.otherPlayer.getBoard().getMatrix()[i][j].isMissed()) {
                    view.getRectangles()[i][j].setFill(Color.PURPLE);
                } else if (model.otherPlayer.getBoard().getMatrix()[i][j].isMarked()) {
                    view.getRectangles()[i][j].setFill(Color.ORANGE);

                } else {
                    view.getRectangles()[i][j].setFill(Color.BLACK);
                }
            }
        }

        Integer integer = model.currentPlayer.getTurns() +1;
        view.getLblStatus().setText("Turn number "+ integer.toString());

        view.getLblName().setText(model.currentPlayer.getName());

        if (model.currentPlayer.getLastCell() != null){
            if (model.currentPlayer.getLastCell().isSunken()){
                view.getLblText().setText("Good job you have sunken a ship!");
            }
            else if (model.currentPlayer.getLastCell().isShot()){
                view.getLblText().setText("Nice hit! keep going!");
            }
            else if (model.currentPlayer.getLastCell().isMissed()){
                view.getLblText().setText("The other player missed! \n It's now your turn to strike!");
            }


        }




    }


}
