package be.kdg.battleship.view.PlacementView;

import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class PlacementView extends GridPane {
    private Button btnTest;

    public PlacementView() {
        initialiseNodes();
        layoutNodes();
    }

    private void layoutNodes() {
        super.add(btnTest,10,10);
        setHalignment(btnTest, HPos.CENTER);

    }

    private void initialiseNodes() {
        btnTest = new Button("test");
    }

}
