package be.kdg.battleship.view.BattleshipCompView;

import be.kdg.battleship.model.Battleship;
import be.kdg.battleship.model.Computer;
import be.kdg.battleship.view.EndScreenView.EndScreenPresenter;
import be.kdg.battleship.view.EndScreenView.EndScreenView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BattleshipCompPresenter {
    private Battleship model;
    private BattleshipCompView view;

    public BattleshipCompPresenter(Battleship model, BattleshipCompView view) {
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
                for (int i = 0; i < model.options.getWidthBoard(); i++) {
                    for (int j = 0; j < model.options.getWidthBoard(); j++) {
                        if (model.player2.getBoard().getMatrix()[i][j].isMarked() && !model.otherPlayer.getBoard().getMatrix()[i][j].isMissed()) {
                            x = model.player2.getBoard().getMatrix()[i][j].getX();
                            y = model.player2.getBoard().getMatrix()[i][j].getY();
                            model.player1.fire(x, y, model.player2);
                        }
                    }
                }
                updateView();
                if (model.player2.getBoard().getMatrix()[x][y].isMissed()){
                    model.player2.fire(model.player1);
                    updateView();
                    if (model.checkWin()){

                        EndScreenView endScreenView = new EndScreenView(model.options);
                        EndScreenPresenter endScreenPresenter = new EndScreenPresenter(model,endScreenView);

                        view.getScene().setRoot(endScreenView);
                        //placementView.getScene().getWindow().sizeToScene();
                        endScreenView.getScene().getWindow().setWidth(1280);
                        endScreenView.getScene().getWindow().setHeight(720);
                    }
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
                view.getBoardCPU().getRectangles()[i][j].setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        Rectangle rectangle = (Rectangle) mouseEvent.getSource();
                        int x = (int) rectangle.getX();
                        int y = (int) rectangle.getY();
                        for (int k = 0; k < 10; k++) {
                            for (int l = 0; l < 10; l++) {
                                if (model.player2.getBoard().getMatrix()[k][l].isMarked()) {
                                    model.player2.getBoard().getMatrix()[k][l].setMarked(false);
                                    //view.getRectangles()[k][l].setFill(Color.BLACK);

                                }
                            }
                        }

                        model.player2.getBoard().getMatrix()[x][y].setMarked(true);
                        updateView();


                    }
                });

            }
        }


    }
    private void updateView() {
        for (int i = 0; i < model.options.getWidthBoard(); i++) {
            for (int j = 0; j < model.options.getWidthBoard(); j++) {
                if (model.player2.getBoard().getMatrix()[i][j].isSunken()){
                    view.getBoardCPU().getRectangles()[i][j].setFill(Color.RED);
                }
                else if (model.player2.getBoard().getMatrix()[i][j].isShot()){
                    view.getBoardCPU().getRectangles()[i][j].setFill(Color.LIME);
                }
                else if (model.player2.getBoard().getMatrix()[i][j].isMissed()) {
                    view.getBoardCPU().getRectangles()[i][j].setFill(Color.PURPLE);
                } else if (model.player2.getBoard().getMatrix()[i][j].isMarked()) {
                    view.getBoardCPU().getRectangles()[i][j].setFill(Color.ORANGE);
                }
                else {
                    view.getBoardCPU().getRectangles()[i][j].setFill(Color.BLACK);

                }
            }
        }
        for (int i = 0; i < model.options.getWidthBoard(); i++) {
            for (int j = 0; j < model.options.getWidthBoard(); j++) {
                if (model.player1.getBoard().getMatrix()[i][j].isSunken()){
                    view.getBoardp1().getRectangles()[i][j].setFill(Color.RED);
                }
                else if (model.player1.getBoard().getMatrix()[i][j].isShot()){
                    view.getBoardp1().getRectangles()[i][j].setFill(Color.LIME);
                }
                else if (model.player1.getBoard().getMatrix()[i][j].isMissed()) {
                    view.getBoardp1().getRectangles()[i][j].setFill(Color.PURPLE);

                }
                else if (model.player1.getBoard().getMatrix()[i][j].getShip() != null){
                    view.getBoardp1().getRectangles()[i][j].setFill(Color.GOLD);
                }
                else {
                    view.getBoardp1().getRectangles()[i][j].setFill(Color.BLACK);

                }
            }
        }


    }

}
