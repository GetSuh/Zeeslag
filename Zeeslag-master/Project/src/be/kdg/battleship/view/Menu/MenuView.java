package be.kdg.battleship.view.Menu;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;


public class MenuView extends BorderPane {
    //TODO:Menu
    private Button btnStart;

    public MenuView() {
        initialiseNodes();
        layoutNodes();
    }

    private void layoutNodes() {
        setCenter(btnStart);
        setAlignment(btnStart, Pos.CENTER);
    }

    private void initialiseNodes() {
        btnStart = new Button("Start");
    }

    public Button getBtnStart() {
        return btnStart;
    }
}
