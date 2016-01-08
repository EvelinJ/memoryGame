package memoryGame;

import javafx.animation.FadeTransition;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
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
    private int pildiKylg = 150;
    public Text number = new Text();
    //private Pilt valitud = null;
    //private int klikiLugeja = 2;


    public Pilt(String value) {
        Rectangle kaart = new Rectangle();//teeb kaardi
        kaart.setWidth(pildiKylg);//kaardi laius
        kaart.setHeight(pildiKylg);//kaardi kõrgus
        kaart.setFill(Color.BLUE);//sinist värvi kaart
        kaart.setStroke(Color.BLACK);//kaardi piirjooned

        number.setText(value);
        number.setFont(Font.font(90));//numbri suurus pildil

        setAlignment(Pos.CENTER);//number asetseb keskel
        getChildren().addAll(kaart, number);

        /*//EI TÖÖTA
        //kutsub välja klikiLugejagaHiireKlikk meetodi
        setOnMouseClicked(this::klikiLugejagaHiireKlikk);
        //peidab pildid
        peidaPilt();*/


    }

    /*//EI TÖÖTA
    public void klikiLugejagaHiireKlikk(MouseEvent mouseEvent) {
        System.out.println("Klikkisin");
        if (piltOnAvatud() || klikiLugeja == 0)
            return;

        klikiLugeja--;


        if (valitud == null) {//tuleb iga pildi avamisega siia, aga edasi else lausega ei lähe, sest vaatab igat pilti eraldi?
            System.out.println(valitud);
            valitud = this;
            System.out.println(valitud);
            avaPilt(() -> {});
        } else {
            avaPilt(() -> {
                if (!tekkisPaar(valitud)) {
                    valitud.peidaPilt();
                    this.peidaPilt();
                }
                valitud = null;
                klikiLugeja = 2;
            });
        }
    }*/

    //meetod kontrollib, kas tekkis paar, kui tekkis siis on tõene
    public boolean tekkisPaar(Pilt teine) {
        return number.getText().equals(teine.number.getText());
    }



    //meetod, mis kontrollib kas pilt on avatud või mitte, kui on 1, siis on avatud
    public boolean piltOnAvatud() {
        return number.getOpacity() == 1;
    }

    //meetod, mis avab pildi
    public void avaPilt(Runnable action) {
        FadeTransition peida = new FadeTransition(Duration.seconds(0.5), number);
        peida.setToValue(1);
        peida.setOnFinished(event -> action.run());
        peida.play();
    }

    //meetod, mis peidab pildi
    public void peidaPilt() {
        FadeTransition peida = new FadeTransition(Duration.seconds(0.5), number);
        peida.setToValue(0);
        peida.play();
    }


}
