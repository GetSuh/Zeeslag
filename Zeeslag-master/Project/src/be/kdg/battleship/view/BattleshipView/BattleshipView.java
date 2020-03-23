package be.kdg.battleship.view.BattleshipView;

import be.kdg.battleship.model.Option;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;


public class BattleshipView extends GridPane {
    private Option option;

    private HBox hboxBoard;
    private Rectangle[][] rectangles;

    private Label lblName;

    private Label lblText;

    private Label lblStatus;
    private Button btnFire;

    private ImageView imgFire;





    public BattleshipView(Option option) {
        this.option = option;
        rectangles = new Rectangle[option.widthBoard][option.widthBoard];
        initialiseNodes();
        layoutNodes();
    }

    public void layoutNodes() {

        VBox vBox = new VBox();
        setStyle("-fx-background-color: #000000;");
        Font font = new Font("Impact",50);


        add(hboxBoard,1,3);
        setMargin(hboxBoard,new Insets(10));




        lblName.setFont(font);
        lblName.setTextFill(Paint.valueOf("green"));
        lblStatus.setFont(font);
        lblStatus.setTextFill(Paint.valueOf("green"));




        vBox.getChildren().addAll(lblName,lblStatus);
        add(vBox,1,2);







        setValignment(imgFire, VPos.TOP);



        lblText.setFont(new Font("Impact",20));
        lblText.setTextFill(Paint.valueOf("green"));
        lblText.setMinWidth(300);


        VBox vBox1 = new VBox(imgFire,lblText);
        setMargin(vBox1,new Insets(10));
        add(vBox1,3,3);


        this.setHgap(10);
        setAlignment(Pos.CENTER);



    }

    public void initialiseNodes() {
        btnFire = new Button("Fire");
        imgFire = new ImageView("/FIRE BUTTON.png");

        lblText = new Label("Welcome to battleship \n click on a cell to mark and press the fire button to fire");
        lblName =new Label("");
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
                r.setStroke(Color.LIMEGREEN);
                rectangles[i][j] = r;


                row.getChildren().add(r);


            }
            hboxBoard.getChildren().add(row);
        }

    }


    public Button getBtnFire() {
        return btnFire;
    }

    public Label getLblName() {
        return lblName;
    }

    public Rectangle[][] getRectangles() {
        return rectangles;
    }

    public Label getLblStatus() {
        return lblStatus;
    }

    public Label getLblText() {
        return lblText;
    }

    public ImageView getImgFire() {
        return imgFire;
    }
}

