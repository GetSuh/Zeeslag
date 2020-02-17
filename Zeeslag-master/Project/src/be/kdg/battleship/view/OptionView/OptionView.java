package be.kdg.battleship.view.OptionView;



import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;


public class OptionView extends BorderPane {

    public OptionView(final Slider slider, double position, double min, double max) {
        slider.setMin(min);
        slider.setMax(max);
		int range = (int)(max - min + 0.5);
		if (range > 200) {
			slider.setMajorTickUnit(50);
			slider.setMinorTickCount(10);
		} else if (range >= 50) {
			slider.setMajorTickUnit(10);
			slider.setMinorTickCount(5);
		} else if (range >= 10) {
			slider.setMajorTickUnit(5);
			slider.setMinorTickCount(1);
		} else {
			slider.setMajorTickUnit(1);
		slider.setMinorTickCount(1);
		}
        slider.setMajorTickUnit(1);
        slider.setSnapToTicks(true);
        slider.setShowTickMarks(false);
        slider.setShowTickLabels(false);
        slider.setValue(position);
        slider.setOpacity(0.25);
        slider.setBlockIncrement(1.0);

        slider.setOnMouseEntered(e -> {
            slider.setOpacity(1);
        });
        slider.setOnMouseExited(e -> {
            slider.setOpacity(0.5);
        });
    }
}