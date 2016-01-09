package memoryGame;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Created by Evelin.Jogi on 10.12.2015.
 */
public class MemoryGame extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        new Mang();//käivitame mängu, siia saab hiljem uusi mängijaid luua, uusi Mange lisades
    }
}

/*
* KASUTATUD ALLIKAD:
* 1) http://i200.itcollege.ee/
* 2) loengusalvestused
* 3) Tutorial https://www.youtube.com/watch?v=QjuytZhQYo8
*
* memoryGame ehk Main
*    Oskab mängu käivitada
* Mäng (Stage)
*    Oskab mängu seadistada
*    Oskab mängu töös hoida
*    Oskab mängu lõpetada
* Mängija
*    Oskab anda tagasisidet, kui pildipaar arvati ära
*    Oskab anda tagasisidet, kui pildipaari ei arvatud ära
*    Oskab anda tagasisidet, kui mäng on läbi
* Laud (kõik tegevused, mis on piltide grupiga seotud) GridPane
*    Teab, et pildid on olemas
*    Oskab panna pildid lauale (genereeriPildid)
*    Oskab hinnata, kas avatud on samasugused pildid (kas peab teadma samasuguste piltide asukohta??)
*    Oskab kontrollida, kas ära arvamata pilte on veel alles
*    Oskab mängu seisu näidata
* Pilt
*    Teab oma asukohta
*    Teab, kas ta on arvatud
*    Oskab laual kohta valida
*    Oskab saada ära arvatuks
*    Oskab ennast ümberpöörata
*    Oskab jääda avatuks, kui on ära arvatud
*    Oskab öelda, kas on veel arvamata
*
*
 */
