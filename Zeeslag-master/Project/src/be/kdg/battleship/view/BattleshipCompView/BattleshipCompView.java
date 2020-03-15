package be.kdg.battleship.view.BattleshipCompView;

import be.kdg.battleship.model.Option;
import be.kdg.battleship.view.BoardView;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;


public class BattleshipCompView extends GridPane {
    private Option option;
    private BoardView boardp1;
    private BoardView boardCPU;

    private Button btnFire;



    public BattleshipCompView(Option option) {
        this.option = option;
        initialiseNodes();
        layoutNodes();
    }

    private void layoutNodes() {
        super.add(boardp1, 1, 3);
        setMargin(boardp1,new Insets(10));
        setMargin(boardCPU,new Insets(10));
        super.add(boardCPU,0,3);
        super.add(btnFire,6,1);
    }

    private void initialiseNodes() {
        boardp1 = new BoardView(option);
        boardCPU = new BoardView(option);
        btnFire = new Button("Fire");

    }

    public BoardView getBoardp1() {
        return boardp1;
    }

    public BoardView getBoardCPU() {
        return boardCPU;
    }

    public Button getBtnFire() {
        return btnFire;
    }
}
