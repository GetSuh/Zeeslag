package be.kdg.battleship.view.MenuView;

import be.kdg.battleship.view.OptionView.OptionPresenter;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
//import javafx.scene.image.Image;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;


public class MenuView extends BorderPane {

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
        lblTitle.setFont(new Font("Impact",50));
        lblTitle.setTextFill(Paint.valueOf("green"));

        setStyle("-fx-background-color: #000000;");


        setTop(lblTitle);
        setAlignment(lblTitle,Pos.TOP_CENTER);
        VBox vBox = new VBox();
        vBox.getChildren().addAll(ivPvP,ivPvCPU,ivOptions,ivExit);
        setCenter(vBox);
        setAlignment(vBox,Pos.CENTER);
        vBox.setPadding(new Insets(10,50,50,50));
        vBox.setSpacing(30);
        vBox.setAlignment(Pos.CENTER);

    }

    private void initialiseNodes() {
        lblTitle = new Label(" Battleship ");


        ivPvP = new ImageView("/1P VS 2P.png");
        ivPvCPU = new ImageView("/1P VS CPU.png");
        ivOptions = new ImageView("/OPTIONS.png");
        ivExit = new ImageView("/EXIT.png");



        //Image image = new Image("");
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
