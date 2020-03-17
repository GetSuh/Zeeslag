package be.kdg.battleship.view.EndScreenView;

import be.kdg.battleship.model.Option;
import be.kdg.battleship.view.BoardView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EndScreenView extends BorderPane {

    private BoardView victoryBoard;
    private Label lblNameVictory;
    private Label lblTurnsVictory;

    private BoardView defeatBoard;
    private Label lblNameDefeat;
    private Label lblTurnsDefeat;



    private Option option;





    private Button btnSave;
    private Button btnMenu;

    public EndScreenView(Option option) {
        this.option = option;
        initialiseNodes();
        layoutNodes();
    }

    private void layoutNodes() {
        // In de 'Pane' zetten.

        setStyle("-fx-background-color: #000000;");
        Font font = new Font("Impact",15);


        BorderPane bpVictory = new BorderPane(); //
        Label lblVictory = new Label("Victory");
        lblVictory.setFont(font);
        lblVictory.setTextFill(Paint.valueOf("green"));

        lblNameVictory.setFont(new Font("Impact",10));
        lblNameVictory.setTextFill(Paint.valueOf("green"));

        lblTurnsVictory.setFont(font);
        lblTurnsVictory.setTextFill(Paint.valueOf("green"));

        bpVictory.setTop(lblVictory);


        VBox vBoxVictory = new VBox(lblNameVictory, lblTurnsVictory,victoryBoard);
        bpVictory.setCenter(vBoxVictory);
        this.setLeft(bpVictory);
        setAlignment(bpVictory,Pos.CENTER);
        setMargin(bpVictory,new Insets(100));


        BorderPane bpDefeat = new BorderPane();
        Label lblDefeat = new Label("Defeat");
        lblDefeat.setTextFill(Paint.valueOf("green"));

        lblNameDefeat.setFont(new Font("Impact",10));
        lblNameDefeat.setTextFill(Paint.valueOf("green"));

        lblTurnsDefeat.setFont(font);
        lblTurnsDefeat.setTextFill(Paint.valueOf("green"));

        lblDefeat.setFont(font);
        bpDefeat.setTop(lblDefeat);

        VBox vboxDefeat = new VBox(lblNameDefeat,lblTurnsDefeat,defeatBoard);


        bpDefeat.setCenter(vboxDefeat);
        this.setRight(bpDefeat);
        setAlignment(bpDefeat,Pos.CENTER);
        setMargin(bpDefeat,new Insets(100));


        Text text = new Text();
        text.setFont(new Font("sans-serif", 10));


        VBox vBox = new VBox();
        vBox.getChildren().addAll(btnSave, btnMenu,text);
        setCenter(vBox);
        setAlignment(vBox, Pos.CENTER);
        vBox.setPadding(new Insets(10,50,50,50));
        vBox.setSpacing(30);
        vBox.setAlignment(Pos.CENTER);







    }

    private void initialiseNodes() {
        // Nodes maken zoals button = new button, en eigenschappen toevoegen
        btnSave = new Button("SAVE");
        btnMenu = new Button("MENU");

        victoryBoard = new BoardView(option);
        victoryBoard.setVisualSize(25);

        lblNameVictory = new Label("");
        lblTurnsVictory = new Label("");


        defeatBoard = new BoardView(option);

        lblNameDefeat = new Label("");
        lblTurnsDefeat = new Label("");

        defeatBoard.setVisualSize(25);


    }

    public BoardView getVictoryBoard() {
        return victoryBoard;
    }

    public BoardView getDefeatBoard() {
        return defeatBoard;
    }

    public Button getBtnSave() {
        return btnSave;
    }

    public Button getBtnMenu() {
        return btnMenu;
    }

    public Label getLblNameVictory() {
        return lblNameVictory;
    }

    public Label getLblTurnsVictory() {
        return lblTurnsVictory;
    }
    public Label getLblNameDefeat() {
        return lblNameDefeat;
    }

    public Label getLblTurnsDefeat() {
        return lblTurnsDefeat;
    }
}
