package be.kdg.battleship.view.Placement2View;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Placement2View  extends GridPane {
    private Button btnTest;
    private Button btnNext;
    private HBox hBox;
    private Rectangle[][] rectangles = new Rectangle[10][10];




    public Placement2View() {
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
