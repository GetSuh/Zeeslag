package be.kdg.battleship.view.Menu;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
//import javafx.scene.image.Image;
import javafx.scene.layout.*;


public class MenuView extends BorderPane {
    //TODO:Menu
    private Button btnStart;
    //private BackgroundImage violeta;

    public MenuView() {
        initialiseNodes();
        layoutNodes();
    }

    private void layoutNodes() {
        setCenter(btnStart);
        setAlignment(btnStart, Pos.CENTER);
        //setBackground(new Background(violeta));
    }

    private void initialiseNodes() {
        btnStart = new Button("P1 Vs. P2");
        //Image image = new Image("");
        //violeta = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
    }

    public Button getBtnStart() {
        return btnStart;
    }
}
