package be.kdg.battleship.view.MenuView;

import be.kdg.battleship.view.OptionView.OptionPresenter;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
//import javafx.scene.image.Image;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;


public class MenuView extends BorderPane {
    //TODO:Menu

    private Label lblTitle;

    private ImageView ivPvP;
    private ImageView ivPvCPU;
    private ImageView ivOptions;
    private ImageView ivExit;

    //private BackgroundImage violeta;

    public MenuView() {
        initialiseNodes();
        layoutNodes();
    }

    private void layoutNodes() {
        lblTitle.setFont(new Font("Comic Sans MS",50));


        setTop(lblTitle);
        setAlignment(lblTitle,Pos.TOP_CENTER);
        VBox vBox = new VBox();
        vBox.getChildren().addAll(ivPvP,ivPvCPU,ivOptions,ivExit);
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
        lblTitle = new Label("\uD83D\uDE02 WONYOUNG STANS \uD83D\uDE02");


        ivPvP = new ImageView("/1P VS 2P.png");
        ivPvCPU = new ImageView("/1P VS CPU.png");
        ivOptions = new ImageView("/OPTIONS.png");
        ivExit = new ImageView("/EXIT.png");



        //Image image = new Image("");
        //violeta = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
    }
    public ImageView getIvPvCPU() {
        return ivPvCPU;
    }

    public ImageView getIvOptions() {
        return ivOptions;
    }

    public ImageView getIvExit() {
        return ivExit;
    }

    public ImageView getIvPvP() {
        return ivPvP;
    }
}
