import cz.uhk.zlomky.model.Zlomek;

public class ZlomkyApp {

    public static void main(String[] args) {

        System.out.println("Zlomkoaplikace");

        Zlomek a = new Zlomek(3, 4);
        Zlomek b = new Zlomek(2, 5);

        System.out.printf("a + b = %s\n", a.secti(b).zkrat());
        System.out.printf("a - b = %s\n", a.odecti(b).zkrat());
        System.out.printf("a / b = %s\n", a.vynasob(b).zkrat());
        System.out.printf("a * b = %s\n", a.vydel(b).zkrat());

        Zlomek[] poleZlomku = new Zlomek[3];
        poleZlomku[0] = a;
        poleZlomku[1] = b;
        poleZlomku[2] = a.vydel(b);

        Zlomek s = suma(poleZlomku);
        System.out.printf("suma = %s\n", s);
    }

    public static Zlomek suma(Zlomek[] pole) {
        Zlomek s = new Zlomek(0, 1);
        for (Zlomek z : pole) {
            s = s.secti(z);
        }
        return s.zkrat();
    }

}
