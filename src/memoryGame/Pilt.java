package memoryGame;

import javafx.animation.FadeTransition;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 * Created by Evelin.Jogi on 12.12.2015.
 */
public class Pilt extends StackPane {
    int pildiKylg = 150;
    Text number = new Text();
    //private boolean olenAllesPilt = true;
    public Pilt(String value) {
        Rectangle kaart = new Rectangle();//teeb kaardi
        kaart.setWidth(pildiKylg);//kaardi laius
        kaart.setHeight(pildiKylg);//kaardi kõrgus
        kaart.setFill(Color.BLUE);//sinist värvi kaart
        kaart.setStroke(Color.BLACK);//kardi piirjooned

        number.setText(value);
        number.setFont(Font.font(90));//numbri suurus pildil

        setAlignment(Pos.CENTER);//number asetseb keskel
        getChildren().addAll(kaart, number);

        setOnMouseClicked(event -> avaPilt());
        peidaPilt();

        /*setOnMouseClicked(event -> {
            System.out.println("Klikkisin");
            String pildiId = getId();//teeme id1 ja id2 ja siis if lauses kontrollime, kas võrduvad omavahel, selle asemel, et kontrollime kas on Pilt1 või Pilt2?
            if (pildiId.equals("pilt1")) {//peame siia kahe erineva pildi võrdluse tekitama ja kaks klikki tuleb teha enne hinnangut. If kui on paar.
                kaart.setFill(Color.WHITESMOKE);
                setId("paar");
            } else if (pildiId.equals("pilt2")) {//if kui ei ole paar
                kaart.setFill((Color.BLUE));//kui ei olnud paar, siis värvib siniseks tagasi
                setId(("arvamata"));//panime praegu, et on arvamata, et game overit kontrollida, kui jätame id pilt2, siis ei jõuagi mängu lõppu pilteAlles meetodis
            } else if (pildiId.equals("paar")) {
                System.out.println("Juba arvatud pilt!");
            }
            if (!kasOledAlles()) {//kui pilte ei ole alles siis prindib mäng läbi
                System.out.println("Mäng läbi!");
                //gameOver();
            }
        });*/
    }

    private void avaPilt() {
        FadeTransition peida = new FadeTransition(Duration.seconds(0.5), number);
        peida.setToValue(1);
        peida.play();
    }

    private void peidaPilt() {
        FadeTransition peida = new FadeTransition(Duration.seconds(0.5), number);
        peida.setToValue(0);
        peida.play();
    }

    /*public boolean kasOledAlles() {//EI TÖÖTA, sest ei saa lauda kätte, aga see meetod peaks pigem siin asuma
                return olenAllesPilt;//tagastab meetodi tulemuse ehk et pilte on veel alles, kui seda käsku näeb, siis enam edasi ei lähe
            }*/
}
