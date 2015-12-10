package memoryGame;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Created by Evelin.Jogi on 10.12.2015.
 */
public class Laud {
    Stage mang;
    GridPane laud;
    int pildiKylg = 150;
    int laualTulpasid = 4;
    int laualRidasid = 4;
    int piltideVahe = 5;
    int piksleidLai = pildiKylg*laualTulpasid+(laualTulpasid*piltideVahe);//see on sellepärast selline, et mahuks aknasse ära, vaatame mingi parema lahenduse
    int piksleidKorge = pildiKylg*laualRidasid+(laualRidasid*piltideVahe);



    public Laud () {
        mang = new Stage();//kuidas ma selle mängust kätte saan??
        laud = new GridPane();
        Scene manguStseen = new Scene(laud, piksleidLai, piksleidKorge);
        mang.setScene(manguStseen);
        mang.show();//ava aken
        mang.setOnCloseRequest(event -> System.exit(0));//akna sulgedes läheb programm kinni
        mang.setTitle("Memoriin");

        genereeriPildid();
    }

    private void genereeriPildid() {
        for (int i = 0; i < laualRidasid; i++) {
            for (int j = 0; j < laualTulpasid; j++) {
                Rectangle pilt = new Rectangle(pildiKylg, pildiKylg);
                pilt.setId("Pilt");
                pilt.setFill(Color.BLUE);
                pilt.setStroke(Color.BLACK);//seda võib ka mitte teha
                laud.setHgap(piltideVahe);
                laud.setVgap(piltideVahe);
                laud.add(pilt, i, j);
            }
        }
    }


}
