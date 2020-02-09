package be.kdg.battleship.view.PlacementView;

import be.kdg.battleship.model.Battleship;
import be.kdg.battleship.model.Cell;
import be.kdg.battleship.model.Ship;
import be.kdg.battleship.view.Menu.MenuView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.awt.*;


public class PlacementHandler {
    private Battleship battleship;
    private PlacementView placementView;

    public PlacementHandler(Battleship battleship, PlacementView placementView) {
        this.battleship = battleship;
        this.placementView = placementView;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                placementView.getRectangles()[i][j].setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        Rectangle rectangle = (Rectangle) mouseEvent.getSource();
                        //battleship.player1.getCell(rectangle.x,rectangle.y).setShip(new Ship(1,true));
                        updateView();
                        for (int k = 0; k < 10; k++) {
                            for (int l = 0; l <10; l++) {
                                if (placementView.getRectangles()[k][l].equals(mouseEvent.getSource())){
                                    battleship.player1.placeShip(k,l,new Ship(1,true));
                                    placementView.getRectangles()[k][l].setFill(Color.RED);
                                }
                            }
                        }

                    }
                });
            }

        }



    }

    private void updateView() {
//TODO: event voor plaatsen




    }
}
