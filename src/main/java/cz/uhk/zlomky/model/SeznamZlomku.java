package cz.uhk.zlomky.model;

import java.util.ArrayList;
import java.util.List;

public class SeznamZlomku {
    private List<Zlomek> zlomky = new ArrayList<>();

//     přidatZlomek(zlomek): přidá nový zlomek do seznamu

    public void pridatZlomek(Zlomek zlomek) {
        zlomky.add(zlomek);
    }

// ■ odebratZlomek(index): odebere zlomek z daného indexu v seznamu

    public void odstranitZlomek(Zlomek zlomek) {
        zlomky.remove(zlomek);
    }

// ■ vratZlomek(index): vrátí zlomek z daného indexu v seznamu

    public Zlomek vratZlomek(int index) {
        return zlomky.get(index);
    }

// ■ vypisZlomky(): vypíše všechny zlomky v seznamu

    public void vypisZlomky() {
        for (Zlomek zlomek : zlomky) {
            System.out.println(zlomek);
        }
    }

// ■ spoctiSoucet(): vypočítá a vrátí součet všech zlomků v seznamu

    public Zlomek spoctiSoucet() {
        Zlomek soucet = new Zlomek(0, 1);
        for (Zlomek zlomek : zlomky) {
            soucet = soucet.secti(zlomek);
        }
        return soucet;
    }

// ■ spoctiPrumer(): vypočítá a vrátí průměr všech zlomků v seznamu

    public Zlomek spoctiPrumer() {
        if (zlomky.isEmpty()) {
            return new Zlomek(0, 1);
        }
        
        Zlomek soucet = spoctiSoucet();
        return soucet.vynasob(new Zlomek(1, zlomky.size())).zkrat();
    }


}
