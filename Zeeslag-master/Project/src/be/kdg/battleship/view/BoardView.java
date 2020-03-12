package be.kdg.battleship.view;

import be.kdg.battleship.model.Option;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BoardView extends BorderPane {


    private HBox hboxBoard;
    private Rectangle[][] rectangles;

    private Option option;

    public BoardView(Option option) {
        this.option = option;
        rectangles = new Rectangle[option.widthBoard][option.widthBoard];
        initialiseNodes();
        layoutNodes();
    }

    private void layoutNodes() {
        setCenter(hboxBoard);

    }

    private void initialiseNodes() {
        hboxBoard = new HBox();
        for (int i = 0; i < option.widthBoard; i++) {
            VBox row = new VBox();
            for (int j = 0; j < option.widthBoard; j++) {
                Rectangle r = new Rectangle();
                r.setX(i);
                r.setY(j);
                r.setWidth(45);
                r.setHeight(45);
                r.setStroke(Color.LIME);
                rectangles[i][j] = r;
                row.getChildren().add(r);
            }
            hboxBoard.getChildren().add(row);
        }
    }

    public void setVisualSize(double size){

        for (int i = 0; i < option.widthBoard; i++) {
            for (int j = 0; j < option.widthBoard; j++) {
              rectangles[i][j].setWidth(size);
                rectangles[i][j].setHeight(size);
            }

        }
    }

    public Rectangle[][] getRectangles() {
        return rectangles;
    }
}
