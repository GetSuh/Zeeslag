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
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;


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





        super.add(txtFieldNaam, 0, 1);


        super.add(lblNaam,0,0);


        super.add(boardView, 0, 3);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(btnSwitchPlayer,btnHorizontal,btnNext);
        vBox.setSpacing(25);
        super.add(vBox,7,3);


        setHgap(5);
        setMargin(boardView, new Insets(5));
        setMargin(vBox,new Insets(5));

        setAlignment(Pos.CENTER);


        //super.add(hBox,0,0);

    }


    private void initialiseNodes() {
        Font font = new Font("Impact",50);



        lblNaam = new Label("Name");
        lblNaam.setFont(font);
        font = new Font("Impact",15);
        lblNaam.setTextFill(Paint.valueOf("green"));



        txtFieldNaam = new TextField("");
        txtFieldNaam.setFont(font);
        txtFieldNaam.setStyle("-fx-background-color: black; -fx-text-fill: green;-fx-border-color: green;-fx-border-width: 1px");

        btnSwitchPlayer = new Button("Switch Player");
        btnSwitchPlayer.setFont(font);
        btnSwitchPlayer.setMinSize(200,30);
        btnSwitchPlayer.setTextFill(Paint.valueOf("green"));
        btnSwitchPlayer.setStyle("-fx-background-color: #000000 ; -fx-border-width: 1px ; -fx-border-color: green");


        btnNext = new Button("Play");
        btnNext.setMinSize(200,30);
        btnNext.setFont(font);
        btnNext.setTextFill(Paint.valueOf("green"));
        btnNext.setStyle("-fx-background-color: #000000 ; -fx-border-width: 1px ; -fx-border-color: green");



        btnHorizontal = new Button("Horizontal/ Vertical");
        btnHorizontal.setMinSize(200,30);
        btnHorizontal.setFont(font);
        btnHorizontal.setTextFill(Paint.valueOf("green"));
        btnHorizontal.setStyle("-fx-background-color: #000000 ; -fx-border-width: 1px ; -fx-border-color: green");




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

    public Label getLblNaam() {
        return lblNaam;
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
