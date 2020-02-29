package be.kdg.battleship.view.BattleshipCompView;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BattleshipCompView extends GridPane {
    private Rectangle[][] rectangles = new Rectangle[10][10];
    private HBox hboxBoard;
    private Button btnPlay;



    public BattleshipCompView() {
        initialiseNodes();
        layoutNodes();
    }

    private void layoutNodes() {
        super.add(hboxBoard, 0, 3);
        super.add(btnPlay,6,1);
    }

    private void initialiseNodes() {

        btnPlay = new Button("Play");
        hboxBoard = new HBox();
        for (int i = 0; i < 10; i++) {
            VBox row = new VBox();
            for (int j = 0; j < 10; j++) {
                Rectangle r = new Rectangle();
                r.setX(i);
                r.setY(j);
                r.setWidth(45);
                r.setHeight(45);
                r.setStroke(Color.WHITE);
                rectangles[i][j] = r;


                row.getChildren().add(r);


            }
            hboxBoard.getChildren().add(row);
        }
    }

}
