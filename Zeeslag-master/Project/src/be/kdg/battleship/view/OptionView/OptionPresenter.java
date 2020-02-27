package be.kdg.battleship.view.OptionView;

import be.kdg.battleship.model.Battleship;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
                optionView.getLblValSlider().setText("Value: " + t1);





            }
        });
    }
}
