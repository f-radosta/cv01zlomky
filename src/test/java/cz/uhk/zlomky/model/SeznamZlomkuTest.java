package cz.uhk.zlomky.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SeznamZlomkuTest {

    private SeznamZlomku seznam;
    private Zlomek zlomek1;
    private Zlomek zlomek2;
    private Zlomek zlomek3;

    @BeforeEach
    public void setUp() {
        seznam = new SeznamZlomku();
        zlomek1 = new Zlomek(1, 2);
        zlomek2 = new Zlomek(1, 3);
        zlomek3 = new Zlomek(1, 4);
    }

    @Test
    public void testPridatZlomek() {
        // Test přidání zlomku
        seznam.pridatZlomek(zlomek1);
        assertEquals(zlomek1, seznam.vratZlomek(0));
        
        // Test přidání více zlomků
        seznam.pridatZlomek(zlomek2);
        seznam.pridatZlomek(zlomek3);
        assertEquals(zlomek2, seznam.vratZlomek(1));
        assertEquals(zlomek3, seznam.vratZlomek(2));
    }

    @Test
    public void testOdstranitZlomek() {
        // Přidání zlomků
        seznam.pridatZlomek(zlomek1);
        seznam.pridatZlomek(zlomek2);
        seznam.pridatZlomek(zlomek3);
        
        // Odstranění zlomku
        seznam.odstranitZlomek(zlomek2);
        
        // Kontrola, že seznam nyní obsahuje pouze zlomek1 a zlomek3
        assertEquals(zlomek1, seznam.vratZlomek(0));
        assertEquals(zlomek3, seznam.vratZlomek(1));
        
        // Kontrola, že pokus o přístup k indexu 2 vyhodí IndexOutOfBoundsException
        assertThrows(IndexOutOfBoundsException.class, () -> seznam.vratZlomek(2));
    }

    @Test
    public void testVratZlomek() {
        seznam.pridatZlomek(zlomek1);
        seznam.pridatZlomek(zlomek2);
        
        assertEquals(zlomek1, seznam.vratZlomek(0));
        assertEquals(zlomek2, seznam.vratZlomek(1));
        
        // Test mimo rozsah
        assertThrows(IndexOutOfBoundsException.class, () -> seznam.vratZlomek(2));
        assertThrows(IndexOutOfBoundsException.class, () -> seznam.vratZlomek(-1));
    }

    @Test
    public void testVypisZlomky() {
        // Tato metoda pouze vypisuje na konzoli, takže nemůžeme snadno testovat výstup
        // Pouze ověříme, že nevyhodí výjimku
        seznam.pridatZlomek(zlomek1);
        seznam.pridatZlomek(zlomek2);
        
        // Nemělo by vyhodit výjimku
        assertDoesNotThrow(() -> seznam.vypisZlomky());
    }

    @Test
    public void testSpoctiSoucet() {
        // Test s prázdným seznamem
        Zlomek emptySoucet = seznam.spoctiSoucet();
        assertEquals(0, emptySoucet.getCitatel());
        assertEquals(1, emptySoucet.getJmenovatel());
        
        // Test s jedním zlomkem
        seznam.pridatZlomek(zlomek1); // 1/2
        Zlomek soucet1 = seznam.spoctiSoucet();
        assertEquals(1, soucet1.getCitatel());
        assertEquals(2, soucet1.getJmenovatel());
        
        // Test s více zlomky
        seznam.pridatZlomek(zlomek2); // 1/3
        seznam.pridatZlomek(zlomek3); // 1/4
        
        // Očekáváno: 1/2 + 1/3 + 1/4 = (6 + 4 + 3)/12 = 13/12
        Zlomek soucet2 = seznam.spoctiSoucet();
        
        // Ruční výpočet očekávaného výsledku
        // 1/2 + 1/3 = (3 + 2)/6 = 5/6
        // 5/6 + 1/4 = (20 + 6)/24 = 26/24 = 13/12
        assertEquals(13, soucet2.getCitatel());
        assertEquals(12, soucet2.getJmenovatel());
    }

    @Test
    public void testSpoctiPrumer() {
        // Test s prázdným seznamem - měl by vrátit 0/1
        Zlomek emptyPrumer = seznam.spoctiPrumer();
        assertEquals(0, emptyPrumer.getCitatel());
        assertEquals(1, emptyPrumer.getJmenovatel());
        
        // Test s jedním zlomkem
        seznam.pridatZlomek(zlomek1); // 1/2
        Zlomek prumer1 = seznam.spoctiPrumer();
        assertEquals(1, prumer1.getCitatel());
        assertEquals(2, prumer1.getJmenovatel());
        
        // Test s více zlomky
        seznam.pridatZlomek(zlomek2); // 1/3
        seznam.pridatZlomek(zlomek3); // 1/4
        
        // Očekáváno: (1/2 + 1/3 + 1/4)/3 = 13/12 * 1/3 = 13/36
        Zlomek prumer2 = seznam.spoctiPrumer();
        
        // Výpočet průměru:
        // Součet: 1/2 + 1/3 + 1/4 = 13/12
        // Průměr: 13/12 * 1/3 = 13/36
        assertEquals(13, prumer2.getCitatel());
        assertEquals(36, prumer2.getJmenovatel());
    }
}
