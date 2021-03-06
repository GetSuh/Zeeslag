package be.kdg.battleship;

import be.kdg.battleship.model.Battleship;

import be.kdg.battleship.view.MenuView.MenuPresenter;
import be.kdg.battleship.view.MenuView.MenuView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        //Battleship battleship = new Battleship();
        //battleship.start();
        launch(args);


    }

    @Override
    public void start(Stage stage) throws Exception {
        Battleship battleship = new Battleship();
        MenuView menuView = new MenuView();
        MenuPresenter handler = new MenuPresenter(battleship,menuView);

        Scene scene = new Scene(menuView);
        stage.setScene(scene);
        stage.setTitle("BattleShip");
        stage.setWidth(1280);
        stage.setHeight(720);
        stage.show();

    }
}
