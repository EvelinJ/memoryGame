package memoryGame;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by Evelin.Jogi on 10.12.2015.
 */
public class Mang {
    Stage mang;

    public Mang () {
        //seadista mäng
        mang = new Stage();
        new Laud();

    }
}
