package be.kdg.battleship.view.OptionView;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class OptionPresenter {
    private VBox makeSlider(int value) {
        Text text = new Text();
        text.setFont(new Font("sans-serif", 10));
        Slider slider = new Slider();
        slider.setOrientation(Orientation.VERTICAL);
        slider.setPrefHeight(150);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit(10);
        slider.setMinorTickCount(0);
        slider.setShowTickLabels(false);
        slider.valueProperty().addListener(
                (observable, oldvalue, newvalue) ->
                {
                    int i = newvalue.intValue();
                    text.setText(Integer.toString(i));
                } );
        slider.setValue(value);
        VBox box = new VBox(10, slider, text);
        box.setPadding(new Insets(10));
        box.setAlignment(Pos.CENTER);
        box.setMinWidth(30);
        box.setPrefWidth(30);
        box.setMaxWidth(30);
        return box;
    }
}
