package cz.uhk.zlomky.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ZlomekTest {

    @Test
    public void testConstructorAndGetters() {
        Zlomek zlomek = new Zlomek(3, 4);
        assertEquals(3, zlomek.getCitatel());
        assertEquals(4, zlomek.getJmenovatel());
    }

    @Test
    public void testSecti() {
        Zlomek zlomek1 = new Zlomek(1, 2);
        Zlomek zlomek2 = new Zlomek(1, 3);
        Zlomek result = zlomek1.secti(zlomek2);
        
        // 1/2 + 1/3 = (1*3 + 2*1)/(2*3) = 5/6
        assertEquals(5, result.getCitatel());
        assertEquals(6, result.getJmenovatel());
    }

    @Test
    public void testOdecti() {
        Zlomek zlomek1 = new Zlomek(3, 4);
        Zlomek zlomek2 = new Zlomek(1, 4);
        Zlomek result = zlomek1.odecti(zlomek2);
        
        // 3/4 - 1/4 = (3*4 - 4*1)/(4*4) = 8/16 = 1/2
        assertEquals(8, result.getCitatel());
        assertEquals(16, result.getJmenovatel());
    }

    @Test
    public void testVynasob() {
        Zlomek zlomek1 = new Zlomek(2, 3);
        Zlomek zlomek2 = new Zlomek(3, 5);
        Zlomek result = zlomek1.vynasob(zlomek2);
        
        // 2/3 * 3/5 = 6/15
        assertEquals(6, result.getCitatel());
        assertEquals(15, result.getJmenovatel());
    }

    @Test
    public void testVydel() {
        Zlomek zlomek1 = new Zlomek(2, 3);
        Zlomek zlomek2 = new Zlomek(4, 5);
        Zlomek result = zlomek1.vydel(zlomek2);
        
        // 2/3 ÷ 4/5 = 2/3 * 5/4 = 10/12
        assertEquals(10, result.getCitatel());
        assertEquals(12, result.getJmenovatel());
    }

    @Test
    public void testZkrat() {
        // Test case 1: Fraction that can be reduced
        Zlomek zlomek1 = new Zlomek(6, 8);
        Zlomek result1 = zlomek1.zkrat();
        assertEquals(3, result1.getCitatel());
        assertEquals(4, result1.getJmenovatel());
        
        // Test case 2: Fraction that is already in lowest terms
        Zlomek zlomek2 = new Zlomek(7, 11);
        Zlomek result2 = zlomek2.zkrat();
        assertEquals(7, result2.getCitatel());
        assertEquals(11, result2.getJmenovatel());
        
        // Test case 3: Fraction with negative numerator
        Zlomek zlomek3 = new Zlomek(-10, 15);
        Zlomek result3 = zlomek3.zkrat();
        assertEquals(-2, result3.getCitatel());
        assertEquals(3, result3.getJmenovatel());
    }

    @Test
    public void testToString() {
        Zlomek zlomek = new Zlomek(5, 7);
        assertEquals("5 / 7", zlomek.toString());
    }

    @Test
    public void testWithZeroNumerator() {
        Zlomek zlomek = new Zlomek(0, 5);
        assertEquals(0, zlomek.getCitatel());
        assertEquals(5, zlomek.getJmenovatel());
        
        // Test arithmetic with zero
        Zlomek other = new Zlomek(3, 4);
        
        // 0/5 + 3/4 = 0*4 + 5*3 / 5*4 = 15/20
        Zlomek sum = zlomek.secti(other);
        assertEquals(15, sum.getCitatel());
        assertEquals(20, sum.getJmenovatel());
        
        // 0/5 - 3/4 = 0*4 - 5*3 / 5*4 = -15/20
        Zlomek diff = zlomek.odecti(other);
        assertEquals(-15, diff.getCitatel());
        assertEquals(20, diff.getJmenovatel());
        
        // 0/5 * 3/4 = 0*3 / 5*4 = 0/20
        Zlomek product = zlomek.vynasob(other);
        assertEquals(0, product.getCitatel());
        assertEquals(20, product.getJmenovatel());
    }
}
