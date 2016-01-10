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

    public Pilt(String value) {
        Rectangle kaart = new Rectangle();//teeb kaardi
        kaart.setWidth(pildiKylg);//kaardi laius
        kaart.setHeight(pildiKylg);//kaardi kõrgus
        kaart.setFill(Color.BLUE);//sinist värvi kaart
        kaart.setStroke(Color.BLACK);//kaardi piirjooned

        number.setText(value);
        number.setFont(Font.font(90));//numbri suurus pildil
        number.setMouseTransparent(true);//ütleme, et numbrile ehk textile ei saa klikkida

        setAlignment(Pos.CENTER);//number asetseb pildi keskel
        getChildren().addAll(kaart, number); //paneb lapsed ehk kaardi ja numbri vanemale ehk stackpane'ile, kaart on numbri taga, sest on sulgudes eespool
    }

    //meetod, mis kontrollib kas pilt on avatud või mitte, kui on 1, siis on avatud
    public boolean piltOnAvatud() {
        return number.getOpacity() == 1;
    }

    //meetod, mis avab pildi
    public void avaPilt(Runnable action) {
        setId(number.getText());
        FadeTransition ft = new FadeTransition(Duration.seconds(0.2), number);
        ft.setToValue(1);
        ft.setOnFinished(event -> action.run());
        ft.play();
    }

    //meetod, mis peidab pildi
    public void peidaPilt() {
        FadeTransition ft = new FadeTransition(Duration.seconds(0.2), number);
        ft.setToValue(0);
        ft.play();
    }
}
