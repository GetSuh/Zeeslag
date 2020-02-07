package be.kdg.battleship;

import be.kdg.battleship.model.Battleship;
import be.kdg.battleship.view.BattleshipView;
import be.kdg.battleship.view.Handler;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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
        BattleshipView battleshipView = new BattleshipView();
        Handler handler = new Handler(battleship,battleshipView);
        Label label = new Label("fef");


        Scene scene = new Scene(label);
        stage.setScene(scene);


        stage.setTitle("BattleShip");
        stage.setFullScreen(true);
        stage.show();




    }
}
