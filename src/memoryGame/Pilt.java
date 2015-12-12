package memoryGame;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Created by Evelin.Jogi on 12.12.2015.
 */
public class Pilt extends Rectangle {
    private boolean olenAllesPilt = true;
    public Pilt(int i) {
        super();
        setWidth(i);
        setHeight(i);
        setFill(Color.BLUE);
        setStroke(Color.BLACK);//seda võib ka mitte teha
        setOnMouseClicked(event -> {
            System.out.println("Klikkisin");
            String pildiId = getId();//teeme id1 ja id2 ja siis if lauses kontrollime, kas võrduvad omavahel, selle asemel, et kontrollime kas on Pilt1 või Pilt2?
            if (pildiId.equals("pilt1")) {//peame siia kahe erineva pildi võrdluse tekitama ja kaks klikki tuleb teha enne hinnangut. If kui on paar.
                setFill(Color.WHITESMOKE);
                setId("paar");
            } else if (pildiId.equals("pilt2")) {//if kui ei ole paar
                setFill((Color.BLUE));//kui ei olnud paar, siis värvib siniseks tagasi
                setId(("arvamata"));//panime praegu, et on arvamata, et game overit kontrollida, kui jätame id pilt2, siis ei jõuagi mängu lõppu pilteAlles meetodis
            } else if (pildiId.equals("paar")) {
                System.out.println("Juba arvatud pilt!");
            }
            if (!kasOledAlles()) {//kui pilte ei ole alles siis prindib mäng läbi
                System.out.println("Mäng läbi!");
                //gameOver();
            }
        });
    }

    public boolean kasOledAlles() {//EI TÖÖTA, sest ei saa lauda kätte, aga see meetod peaks pigem siin asuma
                return olenAllesPilt;//tagastab meetodi tulemuse ehk et pilte on veel alles, kui seda käsku näeb, siis enam edasi ei lähe
            }
}
