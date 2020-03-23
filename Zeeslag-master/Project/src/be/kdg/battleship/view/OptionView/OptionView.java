package be.kdg.battleship.view.OptionView;


import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class OptionView extends BorderPane {
    private Slider sldBoard;
    private Label lblValSlider;

    private Slider sldNumberShips;
    private Label lblValShips;

    private VBox vBox;

    private Group root;


    private Button btnBack;



    public OptionView() {


        initialiseNodes();
        layoutNodes();
    }

    private void layoutNodes() {

        setStyle("-fx-background-color: #000000;");

        setCenter(vBox);

        setAlignment(btnBack,Pos.CENTER);
        setMargin(btnBack,new Insets(50));

    }

    private void initialiseNodes() {
        //Nodes maken zoals slider = new slider, en eigenschappen toevoegen van grootte,
        btnBack = new Button("Go back");



        Label lblSlider = new Label("Board width/height");
        lblSlider.setTextFill(Paint.valueOf("green"));
        lblValSlider = new Label(" ");


        sldBoard = new Slider(10, 20, 15); //
        sldBoard.setShowTickLabels(true);

        sldBoard.setValue(10);
        sldBoard.setMinorTickCount(1);

        Label lblSliderShips = new Label("Extra ships with a length of 2 to place");
        lblSliderShips.setTextFill(Paint.valueOf("green"));
        lblValShips = new Label(" ");

        sldNumberShips = new Slider(0,4,2);
        sldNumberShips.setShowTickLabels(true);
        sldNumberShips.setValue(0);
        sldNumberShips.setMinorTickCount(1);




        vBox = new VBox();
        vBox.setPadding(new Insets(20));
        vBox.setSpacing(10);
        vBox.getChildren().addAll(lblSlider, sldBoard, lblValSlider , lblSliderShips , sldNumberShips , lblValShips , btnBack);

    }


    public Slider getSldBoard() {
    return sldBoard;
}

    public Slider getSldNumberShips() {
        return sldNumberShips;
    }

    public Label getLblValSlider() {
        return lblValSlider;
    }

    public Button getBtnBack() {
        return btnBack;
    }

    public Label getLblValShips() {
        return lblValShips;
    }
}