package memoryGame;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Evelin.Jogi on 29.11.2015.
 */
public class Pilt {
    private int[] asukoht; //siin vist peab midagi asnedama, aga tegin praegu pommitamise näite järgi, proovime alguses numbritega lauda saada
    private boolean arvamata = true;

    public Pilt(int lauaServaPikkus) {//5. laev võtab pikkuse 10 vastu
        System.out.println("START PILT");
        genereeriAsukoht(lauaServaPikkus);// 6. käivitab asukoha genereerimise ja annab pikkuse kaasa
    }

    private void genereeriAsukoht(int lauaServaPikkus) {//7. siin saame pikkust kasutada
        Random rand = new Random();
        int x = rand.nextInt(lauaServaPikkus);
        int y = rand.nextInt(lauaServaPikkus);
        asukoht = new int[] {x, y};
        System.out.println(Arrays.toString(asukoht));


    }

    public boolean kasOledArvamata() {
        return arvamata;
    }
}
