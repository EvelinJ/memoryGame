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
    Stage mang;
    GridPane laud;
    int pildiKylg = 150;
    int laualTulpasid = 4;
    int laualRidasid = 4;
    int piltideVahe = 5;
    int piksleidLai = pildiKylg*laualTulpasid+(laualTulpasid*piltideVahe);//see on sellepärast selline, et mahuks aknasse ära, vaatame mingi parema lahenduse
    int piksleidKorge = pildiKylg*laualRidasid+(laualRidasid*piltideVahe);



    public Laud () {
        mang = new Stage();
        laud = new GridPane();
        Scene manguStseen = new Scene(laud, piksleidLai, piksleidKorge);
        mang.setScene(manguStseen);
        mang.show();//ava aken
        mang.setOnCloseRequest(event -> System.exit(0));//akna sulgedes läheb programm kinni
        mang.setTitle("Memoriin");

        genereeriPildid();
        //reageeriKlikile();
        //new Pilt();
    }

    /*private void reageeriKlikile() {
        laud.setOnMouseClicked(event -> {//kuidas teha enne kaks klikki, et if lause käivitada?
            Rectangle pilt = (Rectangle) event.getTarget();//event ütleb, kes on see, kelle peale klikati ja kasutame rectangle meetodeid
            String pildiId = pilt.getId();//teeme id1 ja id2 ja siis if lauses kontrollime, kas võrduvad omavahel, selle asemel, et kontrollime kas on Pilt1 või Pilt2?
            if (pildiId.equals("pilt1")) {//peame siia kahe erineva pildi võrdluse tekitama ja kaks klikki tuleb teha enne hinnangut. If kui on paar.
                pilt.setFill(Color.WHITESMOKE);
                pilt.setId("paar");
            } else if (pildiId.equals("pilt2")) {//if kui ei ole paar
                pilt.setFill((Color.BLUE));//kui ei olnud paar, siis värvib siniseks tagasi
                pilt.setId(("arvamata"));//panime praegu, et on arvamata, et game overit kontrollida, kui jätame id pilt2, siis ei jõuagi mängu lõppu pilteAlles meetodis
            } else if (pildiId.equals("paar")) {
                System.out.println("Arvatud pilt!");
            }

        });
    }*/

    private boolean pilteAlles() {
        for (Node pilt : laud.getChildren()) {
            if (pilt.getId().equals("pilt1")) {//peaksime tegema nii palju if-e, kui meil erinevaid pilte on
                return true;//tagastab meetodi tulemuse ehk et pilte on veel alles, kui seda käsku näeb, siis enam edasi ei lähe
            } else if (pilt.getId().equals("pilt2")) {
                return true;
            }
        }
        System.out.println("Mäng läbi!");
        return false;//if käib kõik pildid läbi ja kui ei jõudnud tulemuseni, et pilte on alles, siis tuleb siia
    }

    private void genereeriPildid() {//tsükkel piltide lauale asetamiseks
        for (int i = 0; i < laualRidasid; i++) {
            for (int j = 0; j < laualTulpasid; j++) {
                //Rectangle pilt = new Rectangle(pildiKylg, pildiKylg);//pildi loomine etteantud mõõtmetega
                Piltkatse pilt = new Piltkatse(pildiKylg);
                int rand = (int) (Math.random() * 2);//meie peame siia tegema rohkem kui kaks valikut, sest paare on üle kahe, võiks korrutada (*2*laualTulpasid), aga kuidas, siis if tsükkel, teha, et ta nii palju erinevaid pilte annaks?
                if (rand == 1) {
                    pilt.setId("pilt1");//pilt1 teab, et on pilt1, aga siia võib igale pildile mingi oma nime panna, et neid erinevalt midagi tegema panna
                } else {
                    pilt.setId("pilt2");
                }
                //pilt.setFill(Color.BLUE);
                //pilt.setStroke(Color.BLACK);//seda võib ka mitte teha
                laud.setHgap(piltideVahe);//tekitab piltide asetuses vahed, et pildid ei oleks üksteise küljes
                laud.setVgap(piltideVahe);
                laud.add(pilt, i, j);
            }
        }
    }


}
