package memoryGame;

/**
 * Created by Evelin.Jogi on 29.11.2015.
 */
public class Laud {
    private int lauaServaPikkus;//3. salvestab pikkuse klassi külge
    private Pilt[] pildid = new Pilt[4]; //4 pilti tuleb

    public Laud(int pikkus) {//2. laud võtab siin pikkuse 10 vastu, mille andsime Mang.java
        lauaServaPikkus = pikkus;
        looPildid();
    }

    private void looPildid() {
        for (int i = 0; i < pildid.length; i++) {
            pildid[i] = new Pilt(lauaServaPikkus);//4. pildile anname sama muutuja kaasa, mis hetkel on 10
        }

    }

    public boolean kasPilteOnAlles() {
        for (Pilt pilt : pildid){
            boolean arvamata = pilt.kasOledArvamata();//küsib igalt pildilt
            if (arvamata){
                return true;
            }
        }
        return false;
    }
}
