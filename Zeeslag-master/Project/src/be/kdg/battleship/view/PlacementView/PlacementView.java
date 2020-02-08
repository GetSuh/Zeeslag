package be.kdg.battleship.view.PlacementView;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class PlacementView extends GridPane {
    private Button btnTest;
    private HBox hBox;




    public PlacementView() {
        initialiseNodes();
        layoutNodes();
    }

    private void layoutNodes() {
        super.add(btnTest,5,5);
        setHalignment(btnTest, HPos.CENTER);
        super.add(hBox,0,0);







    }

    private void initialiseNodes() {
        btnTest = new Button("test");
        VBox vBox = new VBox();
        for (int i = 0; i < 10; i++) {
            HBox row = new HBox();
            for (int j = 0; j < 10; j++) {
                Rectangle r = new Rectangle();
                r.setX(50);
                r.setY(50);
                r.setWidth(50);
                r.setHeight(50);
                r.setStroke(Color.WHITE);

                row.getChildren().add(r);

            }
            vBox.getChildren().add(row);
        }

         hBox= new HBox(50,vBox);





    }

}
