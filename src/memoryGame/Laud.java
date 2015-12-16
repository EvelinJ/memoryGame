package memoryGame;

import javafx.geometry.Insets;
import javafx.scene.Node;
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
    Stage mang;//klassimuutuja, klassis igalpool kättesaadav
    GridPane laud;//klassimuutuja, klassis igalpool kättesaadav
    int pildiKylg = 150;
    int laualTulpasid = 4;
    int laualRidasid = 4;
    int piltideVahe = 5;
    int piksleidLai = pildiKylg*laualTulpasid+(laualTulpasid*piltideVahe);//see on sellepärast selline, et mahuks aknasse ära, vaatame mingi parema lahenduse
    int piksleidKorge = pildiKylg*laualRidasid+(laualRidasid*piltideVahe);
    Pilt [] pildistik = new Pilt[laualRidasid*laualTulpasid];



    public Laud () {
        mang = new Stage();
        laud = new GridPane();
        Scene manguStseen = new Scene(laud, piksleidLai, piksleidKorge);
        mang.setScene(manguStseen);
        mang.show();//ava aken
        mang.setOnCloseRequest(event -> System.exit(0));//akna sulgedes läheb programm kinni
        mang.setTitle("Memoriin");

        genereeriPildid();
    }

    public boolean kasOnPilteAlles() {
        for (Pilt pilt : pildistik) {//pildistik on kirjuatamata
            boolean olenAllesPilt = pilt.kasOledAlles();
            if (olenAllesPilt) {
                return true;//tagastab meetodi tulemuse ehk et pilte on veel alles, kui seda käsku näeb, siis enam edasi ei lähe
            }
        }
        return false;//if käib kõik pildid läbi ja kui ei jõudnud tulemuseni, et pilte on alles, siis tuleb siia
    }

    private void genereeriPildid() {//tsükkel piltide lauale asetamiseks
        for (int i = 0; i < laualRidasid; i++) {
            for (int j = 0; j < laualTulpasid; j++) {
                Pilt pildistik = new Pilt(pildiKylg);//pildi loomine etteantud mõõtmetega
                int rand = (int) (Math.random() * 2);//meie peame siia tegema rohkem kui kaks valikut, sest paare on üle kahe, võiks korrutada (*2*laualTulpasid), aga kuidas, siis if tsükkel, teha, et ta nii palju erinevaid pilte annaks?
                if (rand == 1) {
                    pildistik.setId("pilt1");//pilt1 teab, et on pilt1, aga siia võib igale pildile mingi oma nime panna, et neid erinevalt midagi tegema panna
                } else {
                    pildistik.setId("pilt2");
                }
                laud.setHgap(piltideVahe);//tekitab piltide asetuses vahed, et pildid ei oleks üksteise küljes
                laud.setVgap(piltideVahe);
                laud.add(pildistik, i, j);
            }
        }
    }


}
