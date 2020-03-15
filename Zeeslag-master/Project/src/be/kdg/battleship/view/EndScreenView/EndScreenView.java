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

public class EndScreenView extends BorderPane {

    //TODO: Victory on the left side of the screen and Defeat on the right side
    private BoardView victoryBoard;
    private BoardView defeatBoard;

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
        bpVictory.setTop(lblVictory);

        bpVictory.setCenter(victoryBoard);
        this.setLeft(bpVictory);
        setAlignment(bpVictory,Pos.CENTER_LEFT);
        setMargin(bpVictory,new Insets(10));


        BorderPane bpDefeat = new BorderPane();
        Label lblDefeat = new Label("Defeat");
        lblDefeat.setTextFill(Paint.valueOf("green"));
        lblDefeat.setFont(font);
        bpDefeat.setTop(lblDefeat);
        this.setRight(bpDefeat);
        bpDefeat.setCenter(defeatBoard);
        setAlignment(bpDefeat,Pos.CENTER_RIGHT);
        setMargin(bpDefeat,new Insets(10));


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
        victoryBoard.setVisualSize(10);

        defeatBoard = new BoardView(option);
        defeatBoard.setVisualSize(10);


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
}
