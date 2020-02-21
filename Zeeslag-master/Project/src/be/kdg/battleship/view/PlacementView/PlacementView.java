package be.kdg.battleship.view.PlacementView;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.LinkedList;
import java.util.List;


public class PlacementView extends GridPane {
    //TODO: Button voor horizontaal of verticaal
    private TextField txtFieldNaam;
    private Label lblNaam;

    private Button btnTest;
    private Button btnNext;
    private HBox hboxBoard;
    private HBox hBox;
    private Rectangle[][] rectangles = new Rectangle[10][10];


    public PlacementView() {
        initialiseNodes();
        layoutNodes();
    }

    private void layoutNodes() {
        /*for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                super.add(rectangles[i][j],i,j);
            }
        }*/
        super.add(txtFieldNaam, 1, 0);
        super.add(lblNaam,0,0);

        super.add(hboxBoard, 0, 1);

        super.add(btnTest, 5, 1);
        super.add(btnNext, 6, 1);


        setHgap(5);
        setMargin(hboxBoard, new Insets(5));
        setGridLinesVisible(true);

        //super.add(hBox,0,0);

    }


    private void initialiseNodes() {
        txtFieldNaam = new TextField("");
        lblNaam = new Label("Name");


        btnTest = new Button("horizontal");
        btnNext = new Button("Play");
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

    public HBox gethBox() {
        return hBox;
    }

    public Button getBtnTest() {
        return btnTest;
    }

    public HBox getHboxBoard() {
        return hboxBoard;
    }

    public Button getBtnNext() {
        return btnNext;
    }

    public Rectangle[][] getRectangles() {
        return rectangles;
    }
}
