package memoryGame;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by Evelin.Jogi on 10.12.2015.
 */
public class Mang {
    Stage mang;//klassimuutuja, klassis igalpool kättesaadav

    public Mang () {
        mang = new Stage();

        //loome objektid
        Laud laud = new Laud();
        Mangija mangija = new Mangija();

        //Mängu sisu.
        /*while (laud.kasOnPilteAlles()) {
            boolean paar = laud.kasTekkisPaar;//kasTekkisPaar meetod on kirjutamata
            if (paar) {
                mangija.paar();
            } else {
                mangija.arvamata();
            }
        }*/
        mangija.gameover();
    }
}
