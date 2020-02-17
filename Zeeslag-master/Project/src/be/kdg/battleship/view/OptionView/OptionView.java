package be.kdg.battleship.view.OptionView;



import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class OptionView extends BorderPane {
    private Slider sldBoard;
    private Slider sldNumberShips;
    private VBox vBox;


    public OptionView() {


        initialiseNodes();
        layoutNodes();
    }

    private void layoutNodes() {
        //In de 'Pane' zetten.

        Text text = new Text();
        text.setFont(new Font("sans-serif", 10));
        VBox box = new VBox(10, text);

        box.setPadding(new Insets(10));
        box.setAlignment(Pos.CENTER);
        box.setMinWidth(30); // Min breedte
        box.setPrefWidth(30); // Dat userfriendly is
        box.setMaxWidth(30); //Maximum breedte
        box.getChildren().add(sldBoard); // Je steekt je slider in een box en de box steek je in een pane.
        //box.getChildren().add(sldNumberShips);
        BorderPane.setAlignment(box, Pos.CENTER); // Klassemethodes gebruiken.

    }

    private void initialiseNodes() {
        //Nodes maken zoals slider = new slider, en eigenschappen toevoegen van grootte,

        sldBoard = new Slider(); //
        sldBoard.setOrientation(Orientation.VERTICAL); //
        sldBoard.setPrefHeight(150); //
        sldBoard.setShowTickMarks(true); //
        sldBoard.setMajorTickUnit(10); //
        sldBoard.setMinorTickCount(0); //
       /* slider.setShowTickLabels(false);
                (observable, oldvalue, newvalue) ->
                {
                    int i = newvalue.intValue();
                    text.setText(Integer.toString(i));
                } );
        double value;
        slider.setValue(value);*/


    }



    /*
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
    }*/

    public Slider getSldBoard() {
        return sldBoard;
    }

    public Slider getSldNumberShips() {
        return sldNumberShips;
    }
}