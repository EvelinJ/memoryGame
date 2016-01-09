package memoryGame;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Evelin.Jogi on 10.12.2015.
 */
public class Laud {
    Stage mang;//klassimuutuja, klassis igalpool kättesaadav
    GridPane laud;//klassimuutuja, klassis igalpool kättesaadav
    private int pildiKylg = 150;
    private int laualRidasid = 4;
    private int laualTulpasid = laualRidasid;
    private int paarideArv = (laualRidasid*laualTulpasid)/2;
    private int piltideVahe = 5;
    private int piksleidLai = pildiKylg*laualTulpasid+(laualTulpasid*piltideVahe);//see on sellepärast selline, et mahuks aknasse ära, vaatame mingi parema lahenduse
    private int piksleidKorge = pildiKylg*laualRidasid+(laualRidasid*piltideVahe);
    ArrayList<Pilt> pildid = new ArrayList<>(paarideArv);
    //private Pilt valitud = null;



    public Laud () {
        mang = new Stage();
        laud = new GridPane();
        Scene manguStseen = new Scene(laud, piksleidLai, piksleidKorge);
        mang.setScene(manguStseen);
        mang.show();//ava aken
        mang.setOnCloseRequest(event -> System.exit(0));//akna sulgedes läheb programm kinni
        mang.setTitle("Memoriin");

        genereeriPildid();
        reageeriKlikile();
    }

    private void reageeriKlikile() {
        laud.setOnMouseClicked(event -> {

            // event.getTarget teab millisele rectagelile ehk kaardile klikiti
            Rectangle kaart = (Rectangle) event.getTarget();

            //võtame kasutusse rectangeli vanema ehk pildi
            Pilt pilt = (Pilt) kaart.getParent();
            System.out.println(pilt);

            if (!kasVahemaltUksPiltOnAvatud()) {
                System.out.println("ühtegi pilti ei ole veel avatud");
                String number1 = pilt.number.getText();
                pilt.setId("pilt1");//sa oled pilt 1
                pilt.avaPilt(() -> {});
                System.out.println(pilt.getId());
            } else if (kasVahemaltUksPiltOnAvatud()) {
                System.out.println("vähemalt üks pilt on juba avatud");
                String number2 = pilt.number.getText();
                pilt.setId("pilt2"); // sa oled pilt 2
                System.out.println(pilt.getId());
                pilt.avaPilt(() -> {
                    if (pilt.piltOnAvatud()) {
                        sulePilt();
                    }
                });
            }

            //kui pilt on juba avatud, siis ära tee midagi (ütleb konsoolis, et on juba avatud)
            if (pilt.piltOnAvatud())
                System.out.println("see pilt on juba avatud");
                return;
        });
        //sule mängu alguses kõik pildid
        sulePilt();
    }



    /*//küsib pildi klassist kas tekkis paar
    public boolean kasTekkisPaar () {
        for (Pilt pilt : pildid) {
            boolean paar = pilt.tekkisPaar(valitud);
            if (paar) {
                System.out.println("jah, on küll paar");
                return true;
            }
        }
        return false;
    }*/

    //küsib pildi klassist iga pildi käest kas ta on avatud
    public boolean kasVahemaltUksPiltOnAvatud() {
        for (Pilt pilt : pildid) {
            boolean vahemaltUksPiltOnAvatud = pilt.piltOnAvatud();
            if (vahemaltUksPiltOnAvatud) {
                return true;//tagastab meetodi tulemuse ehk et vähemalt üks pilt on avatud, kui seda käsku näeb, siis enam edasi ei lähe
            }
        }
        return false;//if käib kõik pildid läbi ja kui ei jõudnud tulemuseni, et mingi pilt oleks avatud, siis tuleb siia
    }

    //kutsub pildi klassist meetodi avaPilt
    public void avaPilt () {
        for (Pilt pilt : pildid) {
            pilt.avaPilt(() -> {});
        }
    }

    //kutsub pildi klaasist meetodi peidaPilt
    public void sulePilt () {
        for (Pilt pilt : pildid) {
            pilt.peidaPilt();
        }
    }

    //meetod, mis loob pildid, segab ja asetab lauale
    public void genereeriPildid() {

        //loome piltide paarid ArrayListi
        int nr = 1;

        //kui see lause tõsta laua klassi külge, siis boolean kasVahemaltUksPiltOnAvatud ei näita viga, aga ei tea kas ikka töötab
        for (int i = 0; i < paarideArv; i++) {
            pildid.add(new Pilt(String.valueOf(nr)));//Pildi loomine, prindib numbri tektiväärtusteks, sama mis Pilt pilt = new Pilt(String.valueOf(nr));
            pildid.add(new Pilt(String.valueOf(nr)));
            nr++;//suurendab pildile tulevaid numbreid ühe võrra
        }

        //segame pildid
        Collections.shuffle(pildid);
        System.out.println(pildid);

        //paneme pildid lauda
        for (int i=0; i < pildid.size(); i++) {
            Pilt pilt = pildid.get(i);
            pilt.setTranslateX((pildiKylg+piltideVahe) * (i % laualRidasid));
            pilt.setTranslateY((pildiKylg+piltideVahe) * (i / laualTulpasid));
            laud.getChildren().add(pilt);
        }
    }
}
