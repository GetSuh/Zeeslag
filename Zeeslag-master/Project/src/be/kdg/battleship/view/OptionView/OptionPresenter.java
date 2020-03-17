package be.kdg.battleship.view.OptionView;

import be.kdg.battleship.model.Battleship;
import be.kdg.battleship.model.Cell;
import be.kdg.battleship.view.MenuView.MenuPresenter;
import be.kdg.battleship.view.MenuView.MenuView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.EventListener;

public class OptionPresenter {
    private Battleship model;
    private OptionView optionView;


    //CONSTRUCTOR

    public OptionPresenter(Battleship model, OptionView optionView) {
        this.model = model;
        this.optionView = optionView;
        addEventHandlers();
        updateView();

    }

    private void updateView() {
        //Informatie van view ophalen en doorsturen naar model.


    }

    private void addEventHandlers() {
    //Nodes van de view ophalen, en event erop zetten.
        optionView.getSldBoard().valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                optionView.getLblValSlider().setText("Value: " + Math.round(t1.doubleValue()));
                model.getOptions().setWidthBoard((int) Math.round(t1.doubleValue()));


            }
        });

        optionView.getBtnBack().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                MenuView view = new MenuView();
                MenuPresenter menuPresenter = new MenuPresenter(model,view);

                System.out.println("width"+model.getOptions().widthBoard);
                model.player1.getBoard().setMatrix(new Cell[model.getOptions().widthBoard][model.getOptions().widthBoard]);
                model.player2.getBoard().setMatrix(new Cell[model.getOptions().widthBoard][model.getOptions().widthBoard]);

                optionView.getScene().setRoot(view);
                view.getScene().getWindow().setWidth(1280);
                view.getScene().getWindow().setHeight(720);

            }
        });
    }
}
