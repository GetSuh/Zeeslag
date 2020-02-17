package be.kdg.battleship.view.PlacementView;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.LinkedList;
import java.util.List;


public class PlacementView extends GridPane {
    //TODO: Button voor horizontaal of verticaal
    private Button btnTest;
    private Button btnNext;
    private HBox hBox;
    private Rectangle[][] rectangles = new Rectangle[10][10];




    public PlacementView() {
        initialiseNodes();
        layoutNodes();
    }

    private void layoutNodes() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                super.add(rectangles[i][j],i,j);
            }
        }
        super.add(btnTest,20,20);
        super.add(btnNext,21,21);

        //super.add(hBox,0,0);

    }


    private void initialiseNodes() {
        btnTest = new Button("horizontal");
        btnNext = new Button("Next");
        //VBox vBox = new VBox();
        for (int i = 0; i < 10; i++) {
            //HBox row = new HBox();
            for (int j = 0; j < 10; j++) {
                Rectangle r = new Rectangle();
                r.setX(i);
                r.setY(j);
                r.setWidth(45);
                r.setHeight(45);
                r.setStroke(Color.WHITE);
                rectangles[i][j] = r;


                //row.getChildren().add(r);


            }
            //vBox.getChildren().add(row);
        }

         //hBox= new HBox(50,vBox);


    }
    public HBox gethBox() {
        return hBox;
    }

    public Button getBtnTest() {
        return btnTest;
    }

    public Button getBtnNext() {
        return btnNext;
    }

    public Rectangle[][] getRectangles() {
        return rectangles;
    }
}
