package be.kdg.battleship.view.PlacementView;

import be.kdg.battleship.Option;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;



public class PlacementView extends GridPane {





    private TextField txtFieldNaam;
    private Label lblNaam;
    private Button btnHorizontal;
    private Button btnNext;
    private Button btnSwitchPlayer;
    private HBox hboxBoard;
    private HBox hBox;
    private Rectangle[][] rectangles;
    private Option options;


    public PlacementView(Option option) {
        this.options = option;
        rectangles = new Rectangle[options.widthBoard][options.widthBoard];
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
        super.add(btnSwitchPlayer,7,1);

        super.add(hboxBoard, 0, 3);

        super.add(btnHorizontal, 5, 1);
        super.add(btnNext, 6, 1);


        setHgap(5);
        setMargin(hboxBoard, new Insets(5));

        setAlignment(Pos.CENTER);
        setGridLinesVisible(true);

        //super.add(hBox,0,0);

    }


    private void initialiseNodes() {
        txtFieldNaam = new TextField("");
        lblNaam = new Label("Name");
        btnSwitchPlayer = new Button("Switch Player");


        btnHorizontal = new Button("horizontal");
        btnNext = new Button("Play");
        hboxBoard = new HBox();
        for (int i = 0; i < options.widthBoard; i++) {
            VBox row = new VBox();
            for (int j = 0; j < options.widthBoard; j++) {
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

    public Button getBtnSwitchPlayer() {
        return btnSwitchPlayer;
    }

    public Button getBtnHorizontal() {
        return btnHorizontal;
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

    public TextField getTxtFieldNaam() {
        return txtFieldNaam;
    }
}
