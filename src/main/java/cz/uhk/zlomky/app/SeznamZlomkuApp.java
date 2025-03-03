package cz.uhk.zlomky.app;

import cz.uhk.zlomky.model.SeznamZlomku;
import cz.uhk.zlomky.model.Zlomek;

public class SeznamZlomkuApp {
    public static void main(String[] args) {
        SeznamZlomku seznam = new SeznamZlomku();
        seznam.pridatZlomek(new Zlomek(1, 2));
        seznam.pridatZlomek(new Zlomek(1, 3));
        seznam.pridatZlomek(new Zlomek(1, 4));
        seznam.pridatZlomek(new Zlomek(1, 5));
        seznam.pridatZlomek(new Zlomek(1, 6));
        seznam.vypisZlomky();
        System.out.println(seznam.spoctiSoucet());
        System.out.println(seznam.spoctiPrumer());

        //Zlomek suma = seznam.spoctiSoucet();
        
        
    }
}
