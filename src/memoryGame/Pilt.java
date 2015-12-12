package memoryGame;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Created by Evelin.Jogi on 12.12.2015.
 */
/*public class Pilt {
    public Pilt() {

        reageeriKlikile();
    }

    private void reageeriKlikile() {
        pilt.setOnMouseClicked(event -> {//kuidas teha enne kaks klikki, et if lause käivitada?
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
            if (!pilteAlles()) {//kui pilte ei ole alles siis prindib mäng läbi
                System.out.println("Mäng läbi!");
                //gameOver();
            }
        });
    }
}*/
