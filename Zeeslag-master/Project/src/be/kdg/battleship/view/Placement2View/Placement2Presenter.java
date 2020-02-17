package be.kdg.battleship.view.Placement2View;

import be.kdg.battleship.model.Battleship;
import be.kdg.battleship.model.Ship;
import be.kdg.battleship.view.PlacementView.PlacementView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Placement2Presenter {
    private Battleship battleship;
    private Placement2View placement2View;

    public Placement2Presenter(Battleship battleship, Placement2View placement2View) {
        this.battleship = battleship;
        this.placement2View = placement2View;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {


        placement2View.getBtnTest().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                for (Ship ship : battleship.player2.getShipsToPlace()) {
                    ship.setHorizontal(!ship.isHorizontal());
                }

            }
        });
        if (battleship.player2.getShipsToPlace().size() != 0){
            placement2View.getBtnNext().setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {

                }
            });
        }





        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                placement2View.getRectangles()[i][j].setOnMouseClicked(new EventHandler<MouseEvent>() {
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
                        if (battleship.player2.getShipsToPlace().size() != 0){
                            battleship.player2.placeShip(x,y,battleship.player2.getShipsToPlace().get(0));
                        }




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
                if (battleship.player2.getBoard().getMatrix()[i][j].getShip() == null) {
                    placement2View.getRectangles()[i][j].setFill(Color.BLACK);
                }
                else{
                    placement2View.getRectangles()[i][j].setFill(Color.BLUE);

                }
            }
        }


    }
}
