package be.kdg.battleship.view.MenuView;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
//import javafx.scene.image.Image;
import javafx.scene.layout.*;


public class MenuView extends BorderPane {
    //TODO:Menu
    private Button btnStart;
    private Button btnStart2;
    private Button btnOption;
    private Button btnExit;


    //private BackgroundImage violeta;

    public MenuView() {
        initialiseNodes();
        layoutNodes();
    }

    private void layoutNodes() {
        VBox vBox = new VBox();
        vBox.getChildren().addAll(btnStart,btnStart2,btnOption,btnExit);
        setCenter(vBox);
        setAlignment(vBox,Pos.CENTER);
        vBox.setPadding(new Insets(10,50,50,50));
        vBox.setSpacing(30);
        vBox.setAlignment(Pos.CENTER);

        /*setAlignment(btnStart, Pos.CENTER);
        setCenter(btnStart2);
        setAlignment(btnStart2, Pos.CENTER);
        setCenter(btnOption);
        setAlignment(btnOption,Pos.CENTER);
        setCenter(btnExit);
        setAlignment(btnExit,Pos.CENTER);*/
        //setBackground(new Background(violeta));
    }

    private void initialiseNodes() {
        btnStart = new Button("P1 Vs. P2");
        btnStart2 = new Button("P1 VS CPU");
        btnOption = new Button("Options");
        btnExit = new Button("Exit");

        //Image image = new Image("");
        //violeta = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
    }

    public Button getBtnStart() {
        return btnStart;
    }
}