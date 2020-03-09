package be.kdg.battleship.view.PlacementView;

import be.kdg.battleship.model.Battleship;
import be.kdg.battleship.model.Ship;
import be.kdg.battleship.view.BattleshipView.BattleshipPresenter;
import be.kdg.battleship.view.BattleshipView.BattleshipView;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class PlacementPresenter {
    private Battleship battleship;
    private PlacementView placementView;

    public PlacementPresenter(Battleship battleship, PlacementView placementView) {
        this.battleship = battleship;
        this.placementView = placementView;

        battleship.setPlayers(battleship.player1, battleship.player2);

        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {

        placementView.getBtnSwitchPlayer().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                battleship.switchPlayer();
                updateView();
            }
        });




        placementView.getTxtFieldNaam().setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode() == KeyCode.ENTER) {
                    if (placementView.getTxtFieldNaam().equals("d")){
                        System.out.println("no name");

                    }
                    String text = placementView.getTxtFieldNaam().getText();
                    battleship.currentPlayer.setName(text);
                    //TODO: set name

                }
            }
        });

        placementView.getBtnUndo().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

            }
        });


        placementView.getBtnHorizontal().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                for (Ship ship : battleship.currentPlayer.getShipsToPlace()) {
                    ship.setHorizontal(!ship.isHorizontal());
                }


            }
        });
        placementView.getBtnNext().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (battleship.player1.getShipsToPlace().size() <= 0 && battleship.player2.getShipsToPlace().size() <= 0) {
                    BattleshipView battleshipView = new BattleshipView(battleship.options);
                    BattleshipPresenter placement2Presenter = new BattleshipPresenter(battleship, battleshipView);
                    placementView.getScene().setRoot(battleshipView);
                    battleshipView.getScene().getWindow().setWidth(1280);
                    battleshipView.getScene().getWindow().setHeight(720);
                } else {
                    //TODO: EXCEPTION

                }


            }
        });


        for (int i = 0; i < battleship.options.getWidthBoard(); i++) {
            for (int j = 0; j < battleship.options.getWidthBoard(); j++) {
                placementView.getBoardView().getRectangles()[i][j].setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        Rectangle rectangle = (Rectangle) mouseEvent.getSource();
                        //battleship.player1.getCell((int)rectangle.getX(),(int)rectangle.getY()).setShip(new Ship(1,true));

                        int x = (int) rectangle.getX();
                        int y = (int) rectangle.getY();
                        System.out.println(x);
                        System.out.println(y);
                        //System.out.println(battleship.player1.placeAble(x, y, new Ship(1, false)));
                        //System.out.println( battleship.player1.placeShip(x, y, new Ship(1, false)));

                        if (!battleship.currentPlayer.getShipsToPlace().isEmpty()){
                            battleship.currentPlayer.placeShip(x, y, battleship.currentPlayer.getShipsToPlace().get(0));
                        }


                        updateView();
                    }
                });
            }
        }
    }

    private void updateView() {

        for (int i = 0; i < battleship.options.getWidthBoard(); i++) {
            for (int j = 0; j < battleship.options.getWidthBoard(); j++) {
                if (battleship.currentPlayer.getBoard().getMatrix()[i][j].getShip() != null) {
                    placementView.getBoardView().getRectangles()[i][j].setFill(Color.GREEN);
                }else placementView.getBoardView().getRectangles()[i][j].setFill(Color.BLACK);

            }


        }


    }
}
