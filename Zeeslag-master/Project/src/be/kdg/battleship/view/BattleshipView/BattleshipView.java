package be.kdg.battleship.view.BattleshipView;

import be.kdg.battleship.model.Option;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class BattleshipView extends GridPane {
    private Option option;

    private HBox hboxBoard;
    private Rectangle[][] rectangles;


    private Label lblStatus;
    private Button btnFire;
    private Button btnNextTurn;



    public BattleshipView(Option option) {
        this.option = option;
        rectangles = new Rectangle[option.widthBoard][option.widthBoard];
        initialiseNodes();
        layoutNodes();
    }

    public void layoutNodes() {
        setGridLinesVisible(true);

        add(hboxBoard,1,3);
        setMargin(hboxBoard,new Insets(10));

        add(lblStatus,1,2);


        add(btnFire,3,3);
        setValignment(btnFire, VPos.TOP);
        setMargin(btnFire,new Insets(10));


        this.setHgap(10);
        setAlignment(Pos.CENTER);



    }

    public void initialiseNodes() {
        btnFire = new Button("Fire");
        lblStatus = new Label("");
        hboxBoard = new HBox();
        for (int i = 0; i < option.widthBoard; i++) {
            VBox row = new VBox();
            for (int j = 0; j < option.widthBoard; j++) {
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


    public Button getBtnFire() {
        return btnFire;
    }


    public Rectangle[][] getRectangles() {
        return rectangles;
    }

    public Label getLblStatus() {
        return lblStatus;
    }

}

