package be.kdg.battleship.view.PlacementView;

import be.kdg.battleship.model.Battleship;
import be.kdg.battleship.model.Ship;
import be.kdg.battleship.view.BattleshipView.BattleshipPresenter;
import be.kdg.battleship.view.BattleshipView.BattleshipView;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class PlacementPresenter {
    private Battleship battleship;
    private PlacementView placementView;

    public PlacementPresenter(Battleship battleship, PlacementView placementView) {
        this.battleship = battleship;
        this.placementView = placementView;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {


        placementView.getBtnTest().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (battleship.player1.getShipsToPlace().size() != 0) {
                    for (Ship ship : battleship.player1.getShipsToPlace()) {
                        ship.setHorizontal(!ship.isHorizontal());
                    }
                } else {
                    for (Ship ship : battleship.player2.getShipsToPlace()) {
                        ship.setHorizontal(!ship.isHorizontal());
                    }
                }


            }
        });
        placementView.getBtnNext().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (battleship.player1.getShipsToPlace().size() <= 0 && battleship.player2.getShipsToPlace().size() <= 0) {
                    BattleshipView battleshipView = new BattleshipView();
                    BattleshipPresenter placement2Presenter = new BattleshipPresenter(battleship, battleshipView);
                    placementView.getScene().setRoot(battleshipView);
                    battleshipView.getScene().getWindow().setWidth(1280);
                    battleshipView.getScene().getWindow().setHeight(720);
                }


            }
        });


        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                placementView.getRectangles()[i][j].setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        Rectangle rectangle = (Rectangle) mouseEvent.getSource();
                        //battleship.player1.getCell((int)rectangle.getX(),(int)rectangle.getY()).setShip(new Ship(1,true));
                        updateView();
                        int x = (int) rectangle.getX();
                        int y = (int) rectangle.getY();
                        System.out.println(x);
                        System.out.println(y);
                        //System.out.println(battleship.player1.placeAble(x, y, new Ship(1, false)));
                        //System.out.println( battleship.player1.placeShip(x, y, new Ship(1, false)));
                        if (battleship.player1.getShipsToPlace().size() != 0) {
                            battleship.player1.placeShip(x, y, battleship.player1.getShipsToPlace().get(0));

                        } else {
                            if (battleship.player2.getShipsToPlace().size() != 0) {
                                battleship.player2.placeShip(x, y, battleship.player2.getShipsToPlace().get(0));

                            }
                        }
                        updateView();


                        //int length = battleship.player1.getShipsToPlace();

                        //--length;
                        //battleship.player1.setShipsToPlace(length);
                        //System.out.println(battleship.player1.getBoard().getMatrix()[x][y].getShip().getType());


                        //placementView.getRectangles()[(int) rectangle.getX()][(int) rectangle.getY()].setFill(Color.RED);
                        updateView();


                    }
                });
            }
        }
    }

    private void updateView() {


//TODO: event voor plaatsen

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

                if (battleship.player1.getShipsToPlace().size() != 0){
                    if (battleship.player1.getBoard().getMatrix()[i][j].getShip() != null){
                        placementView.getRectangles()[i][j].setFill(Color.RED);
                    } else placementView.getRectangles()[i][j].setFill(Color.BLACK);
                }
                else if (battleship.player2.getShipsToPlace().size() != 0 && placementView.getBtnNext().isPressed()){
                    if (battleship.player2.getBoard().getMatrix()[i][j].getShip() != null){
                        placementView.getRectangles()[i][j].setFill(Color.BLUE);
                    } else placementView.getRectangles()[i][j].setFill(Color.BLACK);
                }
            }
        }





/*
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

                //Player 1
                if (battleship.player1.getBoard().getMatrix()[i][j].getShip() == null) {
                    placementView.getRectangles()[i][j].setFill(Color.BLACK);
                } else placementView.getRectangles()[i][j].setFill(Color.RED);

                //Player 2
                if (battleship.player2.getBoard().getMatrix()[i][j].getShip() == null) {
                    placementView.getRectangles()[i][j].setFill(Color.BLACK);
                } else placementView.getRectangles()[i][j].setFill(Color.BLUE);


            }
        }*/


    }
}
