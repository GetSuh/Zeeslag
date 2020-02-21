package be.kdg.battleship.view.BattleshipView;

import be.kdg.battleship.model.Battleship;
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
        addEventHandlers();
        updateView();
    }



    private void addEventHandlers() {
        view.getBtnFire().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {


                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        if ( model.player2.getBoard().getMatrix()[i][j].isMarked()){
                            int x = model.player2.getBoard().getMatrix()[i][j].getX();
                            int y = model.player2.getBoard().getMatrix()[i][j].getY();
                            model.player1.fire(x,y,model.player2);
                        }
                    }
                }
                updateView();


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
                                if (model.player2.getBoard().getMatrix()[k][l].isMarked()){
                                    model.player2.getBoard().getMatrix()[k][l].setMarked(false);
                                    //TODO: andere manier zoeken
                                    //view.getRectangles()[k][l].setFill(Color.BLACK);
                                    updateView();


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
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

                if (model.player2.getBoard().getMatrix()[i][j].isWasShot()){
                    view.getRectangles()[i][j].setFill(Color.LIME);
                }


                else if (model.player2.getBoard().getMatrix()[i][j].isMissed() && model.player2.getBoard().getMatrix()[i][j].isWasShot() ){
                    view.getRectangles()[i][j].setFill(Color.PURPLE);
                    return;
                }
                else if (model.player2.getBoard().getMatrix()[i][j].isMarked()){
                    view.getRectangles()[i][j].setFill(Color.ORANGE);
                    return;
                } else {
                    view.getRectangles()[i][j].setFill(Color.BLACK);
                }

            }
        }

    }



}
