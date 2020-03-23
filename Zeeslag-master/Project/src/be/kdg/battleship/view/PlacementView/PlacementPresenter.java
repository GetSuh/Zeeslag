package be.kdg.battleship.view.PlacementView;

import be.kdg.battleship.model.Battleship;
import be.kdg.battleship.model.Cell;
import be.kdg.battleship.model.Computer;
import be.kdg.battleship.model.Ship;
import be.kdg.battleship.view.BattleshipCompView.BattleshipCompPresenter;
import be.kdg.battleship.view.BattleshipCompView.BattleshipCompView;
import be.kdg.battleship.view.BattleshipView.BattleshipPresenter;
import be.kdg.battleship.view.BattleshipView.BattleshipView;

import be.kdg.battleship.view.MenuView.MenuPresenter;
import be.kdg.battleship.view.MenuView.MenuView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class PlacementPresenter {
    private Battleship model;
    private PlacementView view;

    public PlacementPresenter(Battleship model, PlacementView view) {
        this.model = model;
        this.view = view;

        model.setPlayers(model.player1, model.player2);

        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {


        view.getBtnBack().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                MenuView view = new MenuView();
                MenuPresenter menuPresenter = new MenuPresenter(new Battleship(),view);
                PlacementPresenter.this.view.getScene().setRoot(view);
                view.getScene().getWindow().setWidth(1280);
                view.getScene().getWindow().setHeight(720);


            }
        });

        view.getBtnSwitchPlayer().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (model.otherPlayer instanceof Computer) {
                    return;
                }

                model.switchPlayer();
                updateView();
            }
        });


        view.getTxtFieldNaam().setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode() == KeyCode.ENTER) {



                    String text = view.getTxtFieldNaam().getText();
                    model.currentPlayer.setName(text);
                    updateView();
                    //TODO: set name

                }
            }
        });

        view.getBtnUndo().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                for (Cell[] matrix : model.currentPlayer.getBoard().getMatrix()) {
                    for (Cell cell : matrix) {
                        if (cell.getShip() != null && cell.getShip().getFollowNumber() == model.currentPlayer.getLastShipPlaced().getFollowNumber()){
                            cell.setShip(null);
                        }
                    }
                }
                model.currentPlayer.getShipsToPlace().add(0, model.currentPlayer.getLastShipPlaced());
                updateView();





            }
        });


        view.getBtnHorizontal().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                for (Ship ship : model.currentPlayer.getShipsToPlace()) {
                    ship.setVertical(!ship.isVertical());

                }
                updateView();


            }
        });
        view.getBtnNext().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (model.player1.getShipsToPlace().size() <= 0 && model.player2.getShipsToPlace().size() <= 0) {
                    if (model.player2 instanceof Computer) {
                        BattleshipCompView battleshipCompView = new BattleshipCompView(model.options);
                        BattleshipCompPresenter battleshipCompPresenter = new BattleshipCompPresenter(model, battleshipCompView);
                        view.getScene().setRoot(battleshipCompView);
                        battleshipCompView.getScene().getWindow().setWidth(1280);
                        battleshipCompView.getScene().getWindow().setHeight(720);

                    } else {
                        BattleshipView battleshipView = new BattleshipView(model.options);
                        BattleshipPresenter placement2Presenter = new BattleshipPresenter(model, battleshipView);
                        view.getScene().setRoot(battleshipView);
                        battleshipView.getScene().getWindow().setWidth(1280);
                        battleshipView.getScene().getWindow().setHeight(720);
                    }


                } else {

                }


            }
        });


        for (int i = 0; i < model.options.getWidthBoard(); i++) {
            for (int j = 0; j < model.options.getWidthBoard(); j++) {
                view.getBoardView().getRectangles()[i][j].setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        Rectangle rectangle = (Rectangle) mouseEvent.getSource();
                        //battleship.player1.getCell((int)rectangle.getX(),(int)rectangle.getY()).setShip(new Ship(1,true));

                        int x = (int) rectangle.getX();
                        int y = (int) rectangle.getY();


                        if (!model.currentPlayer.getShipsToPlace().isEmpty()) {
                            model.currentPlayer.placeShip(x, y, model.currentPlayer.getShipsToPlace().get(0));
                        }


                        updateView();
                    }
                });
            }
        }
    }

    private void updateView() {

        for (int i = 0; i < model.options.getWidthBoard(); i++) {
            for (int j = 0; j < model.options.getWidthBoard(); j++) {
                if (model.currentPlayer.getBoard().getMatrix()[i][j].getShip() != null) {
                    view.getBoardView().getRectangles()[i][j].setFill(Color.GREEN);
                } else view.getBoardView().getRectangles()[i][j].setFill(Color.BLACK);

            }


        }
        view.getTxtFieldNaam().setText(model.currentPlayer.getName());
        if (model.currentPlayer.getName() == null){
            view.getLblNaam().setText("Name");
        }
        else view.getLblNaam().setText(model.currentPlayer.getName());

        if (!model.currentPlayer.getShipsToPlace().isEmpty()){
            if ( model.currentPlayer.getShipsToPlace().get(0).isVertical()){
                view.getBtnHorizontal().setText("Place ship horizontal");
            }
            else {
                view.getBtnHorizontal().setText("Place ship vertical");
            }
        }



    }
}
