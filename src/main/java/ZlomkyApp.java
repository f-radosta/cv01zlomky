import cz.uhk.zlomky.model.Zlomek;

public class ZlomkyApp {

    public static void main(String[] args) {

        System.out.println("Zlomkoaplikace");

        Zlomek a = new Zlomek(3, 4);
        Zlomek b = new Zlomek(2,5);

        System.out.printf("a + b = %s\n", a.secti(b).zkrat());
        System.out.printf("a - b = %s\n", a.odecti(b).zkrat());
        System.out.printf("a / b = %s\n", a.vynasob(b).zkrat());
        System.out.printf("a * b = %s\n", a.vydel(b).zkrat());

    }

}
