package be.kdg.battleship.view.EndScreenView;

import be.kdg.battleship.model.Battleship;
import be.kdg.battleship.view.MenuView.MenuPresenter;
import be.kdg.battleship.view.MenuView.MenuView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EndScreenPresenter {
    private Battleship model;
    private EndScreenView view;

    //CONSTRUCTOR


    public EndScreenPresenter(Battleship model, EndScreenView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();

    }

    private void updateView() {
        ////Informatie van view ophalen en doorsturen naar model.
        for (int i = 0; i < model.options.getWidthBoard(); i++) {
            for (int j = 0; j < model.options.getWidthBoard(); j++) {
                if (model.currentPlayer.getBoard().getMatrix()[i][j].isSunken()) {
                    view.getVictoryBoard().getRectangles()[i][j].setFill(Color.RED);
                } else if (model.currentPlayer.getBoard().getMatrix()[i][j].isShot()) {
                    view.getVictoryBoard().getRectangles()[i][j].setFill(Color.LIME);
                } else if (model.currentPlayer.getBoard().getMatrix()[i][j].isMissed()) {
                    view.getVictoryBoard().getRectangles()[i][j].setFill(Color.PURPLE);
                  
                } else if (model.currentPlayer.getBoard().getMatrix()[i][j].getShip() != null) {
                    view.getVictoryBoard().getRectangles()[i][j].setFill(Color.GOLD);


                } else {
                    view.getVictoryBoard().getRectangles()[i][j].setFill(Color.BLACK);

                }
            }
        }
        for (int i = 0; i < model.options.getWidthBoard(); i++) {
            for (int j = 0; j < model.options.getWidthBoard(); j++) {
                if (model.otherPlayer.getBoard().getMatrix()[i][j].isSunken()) {
                    view.getDefeatBoard().getRectangles()[i][j].setFill(Color.RED);
                } else if (model.otherPlayer.getBoard().getMatrix()[i][j].isShot()) {
                    view.getDefeatBoard().getRectangles()[i][j].setFill(Color.LIME);
                } else if (model.otherPlayer.getBoard().getMatrix()[i][j].isMissed()) {
                    view.getDefeatBoard().getRectangles()[i][j].setFill(Color.PURPLE);
                    System.out.println("x" + i);
                    System.out.println("y" + j);
                } else if (model.otherPlayer.getBoard().getMatrix()[i][j].getShip() != null) {
                    view.getDefeatBoard().getRectangles()[i][j].setFill(Color.GOLD);
                } else {
                    view.getDefeatBoard().getRectangles()[i][j].setFill(Color.BLACK);

                }
            }
        }

        view.getLblNameVictory().setText(model.currentPlayer.getName());
        Integer integer = model.currentPlayer.turns;
        view.getLblTurnsVictory().setText(integer.toString());

        view.getLblNameDefeat().setText(model.otherPlayer.getName());
        integer = model.otherPlayer.turns;

        view.getLblTurnsDefeat().setText(integer.toString());


    }

    private void addEventHandlers() {
        //Nodes van de view ophalen, en event erop zetten.


        view.getImgMenu().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                MenuView menuView = new MenuView();
                MenuPresenter menuPresenter = new MenuPresenter(new Battleship(), menuView);
                view.getScene().setRoot(menuView);
                menuView.getScene().getWindow().setWidth(1280);
                menuView.getScene().getWindow().setHeight(720);
            }
        });



        view.getImgSave().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                Path log = Paths.get("resources/logfile.txt");
                System.out.println(log.getFileName() + " bestaat echt: " + Files.exists(log));


                try {
                    model.writeScores();

                } catch (IOException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Unable to save");
                    alert.setContentText(e.getMessage());
                    alert.showAndWait();

                    //TODO: geen printstrack
                }
                view.getImgSave().setDisable(true);
            }
        });

    }
}
