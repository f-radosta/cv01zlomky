import cz.uhk.zlomky.model.Zlomek;

public class ZlomkyApp {

    public static void main(String[] args) {

        System.out.println("Zlomkoaplikace");

        Zlomek a = new Zlomek(3, 4);

        System.out.printf("Zlomek = %s", a.toString());
    }

}
