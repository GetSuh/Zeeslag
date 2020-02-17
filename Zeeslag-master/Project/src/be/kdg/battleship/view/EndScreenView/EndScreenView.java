package be.kdg.battleship.view.EndScreenView;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class EndScreenView extends BorderPane {

    //TODO: Victory on the left side of the screen and Defeat on the right side

    private Button btnSave;
    private Button btnMenu;

    public EndScreenView() {
        initialiseNodes();
        layoutNodes();
    }

    private void layoutNodes() {
        // In de 'Pane' zetten.
        BorderPane bpVictory = new BorderPane(); //
        bpVictory.setTop(new Label("Victory"));
        bpVictory.setLeft(bpVictory); // Text aan linkerkant plaatsen


        BorderPane bpDefeat = new BorderPane();
        bpVictory.setTop(new Label("Defeat"));
        bpVictory.setRight(bpDefeat);

        Text text = new Text();
        text.setFont(new Font("sans-serif", 10));
        VBox vBox = new VBox();
        vBox.getChildren().addAll(btnSave, btnMenu);
        setCenter(vBox);
        setAlignment(vBox, Pos.CENTER);
        vBox.setPadding(new Insets(10,50,50,50));
        vBox.setSpacing(30);
        vBox.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(vBox, Pos.CENTER);
        BorderPane.setAlignment(bpVictory, Pos.TOP_LEFT);
        BorderPane.setAlignment(bpDefeat, Pos.TOP_RIGHT);

    }

    private void initialiseNodes() {
        // Nodes maken zoals button = new button, en eigenschappen toevoegen
        btnSave = new Button("SAVE");
        btnMenu = new Button("MENU");


    }

    public Button getBtnSave() {
        return btnSave;
    }

    public Button getBtnMenu() {
        return btnMenu;
    }
}
