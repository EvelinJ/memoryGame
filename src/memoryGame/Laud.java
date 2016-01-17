package memoryGame;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Evelin.Jogi on 10.12.2015.
 */
public class Laud {
    Stage mang;//klassimuutuja, klassis igalpool kättesaadav
    BorderPane maailm;
    GridPane laud;//klassimuutuja, klassis igalpool kättesaadav
    private int pildiKylg = 150;
    private int laualRidasid = 4;
    private int laualTulpasid = laualRidasid;
    private int paarideArv = (laualRidasid*laualTulpasid)/2;
    private int piltideVaheLauas = 5;
    private int piksleidLai = pildiKylg*laualTulpasid+(laualTulpasid*piltideVaheLauas);
    private int piksleidKorge = pildiKylg*laualRidasid+(laualRidasid*piltideVaheLauas);
    ArrayList<Pilt> pildid = new ArrayList<>(paarideArv);
    public Pilt esimenePilt;
    public Pilt arvatudPilt;


    public Laud () {
        mang = new Stage();
        mang.setTitle("Memoriin");
        maailm = new BorderPane();
        laud = new GridPane();
        maailm.getChildren().add(laud);
        Scene manguStseen = new Scene(maailm, piksleidLai, piksleidKorge);

        //MENÜÜRIBA
        MenuBar menuuRiba = new MenuBar();
        maailm.setTop(menuuRiba);

        //1. Menüü nupp "Tegevus"
        Menu tegevused = new Menu("_Tegevus");
        tegevused.setMnemonicParsing(true);//avab menüü nupu alt+t

        //Menüü "tegevus" alategevused:
        //1.1. alategevus "Uus mäng"
        MenuItem uusMang = new MenuItem("Uus mäng");
        uusMang.setAccelerator(new KeyCodeCombination(KeyCode.M, KeyCombination.SHORTCUT_DOWN));//kiirklahvid Ctrl+M, et alustada uut mängu
        //1.2. alategevus "Sulge mäng"
        MenuItem sulgeMang = new MenuItem("Sulge mäng");
        sulgeMang.setAccelerator(new KeyCodeCombination(KeyCode.X, KeyCombination.SHORTCUT_DOWN));//kiirklahvid Ctrl+x, et väljuda mängust
        //alategevuse "Sulge mäng" meetod
        sulgeMang.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TeadeTahabValikut.teadeTahabValikut("Sulge mäng", "Kas oled kindel, et soovid mängu sulgeda?");
            }
        });

        //Lisa alategevused menuu nupu "Tegevus" alla
        tegevused.getItems().addAll(uusMang, sulgeMang);

        //2. Menüü nupp "Spikker"
        Menu spikker = new Menu("_Spikker");
        spikker.setMnemonicParsing(true);//avab menüü nupu alt+s

        //2.1. Menüü "Spikker" alategevused
        MenuItem kuidasMangida = new MenuItem("Kuidas mängida?");
        kuidasMangida.setAccelerator(new KeyCodeCombination(KeyCode.F1));
        kuidasMangida.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Teade.teade("Mängu õpetus", " \n" +
                                "Vali hiirega kaardile klikkides kaks kaart. Kui Sul õnnestub avada kaks ühesugust kaarti\n" +
                        "ehk tekib kaardipaar, siis jäävad kaardid mängu lõpuni avatuks.\n" +
                        "Kui kaardid omavahel ei sobi ehk paari ei teki, siis pööratakse need laual uuesti ümber\n" +
                        "ja tuleb valida kaks uut kaarti.\n" +
                        "Mäng lõppeb, kui kõik kaardipaarid on laualt üles leitud.");
            }
        });
        spikker.getItems().addAll(kuidasMangida);

        //Lisa menüü nupud menüüribale
        menuuRiba.getMenus().addAll(tegevused, spikker);

        //VALIKUTERIBA
        ToolBar valikuteriba = new ToolBar();
        maailm.setBottom(valikuteriba);

        //Valikuteriba nupp "Alusta mängu"
        Button alustaMangu = new Button("Alusta mängu");
        valikuteriba.getItems().addAll(alustaMangu);

        mang.setScene(manguStseen);
        mang.show();//ava aken
        mang.setOnCloseRequest(event -> System.exit(0));//akna sulgedes läheb programm kinni


        genereeriPildid();
        reageeriKlikile();
    }

    //klikile reageerimise meetod
    private void reageeriKlikile() {
        laud.setOnMouseClicked(event -> {

            //event.getTarget teab millisele rectagelile ehk kaardile klikiti
            Rectangle kaart = (Rectangle) event.getTarget();

            //võtame kasutusse rectangeli vanema ehk pildi
            Pilt pilt = (Pilt) kaart.getParent();
            System.out.println(pilt);

            //kui pilt on juba avatud, siis ära tee midagi (ütleb konsoolis, et on juba avatud)
            if (pilt.piltOnAvatud())
                return;

            //kui ühtegi pili ei ole avatud siis avab esimese, kui üks on juba avatud siis avab teise
            //EI JÄTA PAARE AVATUKS
            if (!kasVahemaltUksPiltOnAvatud()) {
                System.out.println("ühtegi pilti ei ole veel avatud");
                pilt.avaEsimenePilt(() -> {
                    esimenePilt = pilt;
                    System.out.println(esimenePilt);
                    System.out.println(esimenePilt.getId());
                });
            } else if (kasVahemaltUksPiltOnAvatud()) {
                System.out.println("vähemalt üks pilt on juba avatud");
                pilt.avaTeinePilt(() -> {
                    System.out.println(pilt);
                    System.out.println(pilt.getId());
                    if (!esimenePilt.number.getText().equals(pilt.number.getText())) {
                        System.out.println("Ei ole paar!");
                        esimenePilt.peidaPilt();
                        pilt.peidaPilt();

                    } else {
                        System.out.println("Paar!");
                        esimenePilt.setId("Arvatud");
                        System.out.println(esimenePilt);
                        pilt.setId("Arvatud");
                        System.out.println(pilt);
                    }
                });
            }

        });
        //sule mängu alguses kõik pildid
        suleKoikPildid();
    }


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

    /*//kutsub pildi klassist meetodi avaPilt
    public void avaPilt () {
        for (Pilt pilt : pildid) {
            pilt.avaEsimenePilt(() -> {
            });
        }
    }*/

    //kutsub pildi klaasist meetodi peidaPilt
    public void suleKoikPildid() {
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
            pilt.setTranslateX((pildiKylg+piltideVaheLauas) * (i % laualRidasid));
            pilt.setTranslateY((pildiKylg+piltideVaheLauas) * (i / laualTulpasid));
            laud.getChildren().add(pilt);
        }
    }
}
