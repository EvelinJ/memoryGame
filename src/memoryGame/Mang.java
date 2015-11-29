package memoryGame;

/**
 * Created by Evelin.Jogi on 28.11.2015.
 */
public class Mang {
    public Mang() {
        //seadista mäng
        Laud laud = new Laud (10); //1. lauale anname pikkuse 10 ühikut ette
        //Mangija mangija = new Mangija();

        //mängu töös hoidmine
        while (laud.kasPilteOnAlles()){
            System.out.println("NEXT ROUND");
            
        }
    }
}
