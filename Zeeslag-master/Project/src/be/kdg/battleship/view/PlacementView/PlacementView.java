package be.kdg.battleship.view.PlacementView;

import be.kdg.battleship.model.Option;
import be.kdg.battleship.view.BoardView;
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
    private Button btnUndo; //TODO:undo button
    //TODO: Clickable images of ships

    /* TODO:Exception
    Bij klikken van start moet de boten geplaats zijn




     */



    private BoardView boardView;


    public PlacementView(Option option) {
        boardView = new BoardView(option);
        initialiseNodes();
        layoutNodes();
    }

    private void layoutNodes() {
        setStyle("-fx-background-color: #000000;");

        super.add(txtFieldNaam, 1, 0);

        super.add(lblNaam,0,0);

        super.add(boardView, 0, 3);

        super.add(btnSwitchPlayer,7,1);
        super.add(btnHorizontal, 5, 1);
        super.add(btnNext, 6, 1);


        setHgap(5);
        setMargin(boardView, new Insets(5));

        setAlignment(Pos.CENTER);
        setGridLinesVisible(true);

        //super.add(hBox,0,0);

    }


    private void initialiseNodes() {
        txtFieldNaam = new TextField("");
        lblNaam = new Label("Name");

        btnSwitchPlayer = new Button("Switch Player");
        btnNext = new Button("Play");
        btnHorizontal = new Button("Horizontal/ Vertical");
        btnUndo = new Button("Undo placement");





    }

    public Button getBtnUndo() {
        return btnUndo;
    }

    public Button getBtnSwitchPlayer() {
        return btnSwitchPlayer;
    }

    public Button getBtnHorizontal() {
        return btnHorizontal;
    }



    public Button getBtnNext() {
        return btnNext;
    }

    public BoardView getBoardView() {
        return boardView;
    }

    public TextField getTxtFieldNaam() {
        return txtFieldNaam;
    }
}
