package be.kdg.battleship.view.BattleshipView;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BattleshipView extends GridPane {
    private Label lblSatus;

    private HBox hboxBoard;
    private Button btnFire;
    private Button btnNextTurn;
    private Rectangle[][] rectangles = new Rectangle[10][10];



    public BattleshipView() {
        initialiseNodes();
        layoutNodes();
    }

    public void layoutNodes() {
        setGridLinesVisible(true);

        add(hboxBoard,1,3);
        setMargin(hboxBoard,new Insets(10));

        add(lblSatus,1,2);


        add(btnFire,3,3);
        setValignment(btnFire, VPos.TOP);
        setMargin(btnFire,new Insets(10));


        this.setHgap(10);
        setAlignment(Pos.CENTER_LEFT);



    }

    public void initialiseNodes() {
        btnFire = new Button("Fire");
        lblSatus = new Label("");
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

    public HBox getHboxBoard() {
        return hboxBoard;
    }

    public Button getBtnFire() {
        return btnFire;
    }

    public Button getBtnNextTurn() {
        return btnNextTurn;
    }

    public Rectangle[][] getRectangles() {
        return rectangles;
    }
}

