package cz.uhk.zlomky.model;

public class Zlomek {
    private final int citatel;
    private final int jmenovatel;

    public Zlomek(int citatel, int jmenovatel) {
        this.citatel = citatel;
        this.jmenovatel = jmenovatel;
    }

    public int getCitatel() {
        return citatel;
    }

    public int getJmenovatel() {
        return jmenovatel;
    }

    public Zlomek secti(Zlomek druhy) {
        int novyCitatel = citatel * druhy.getJmenovatel() + jmenovatel * druhy.getCitatel();
        int novyJmenovatel = jmenovatel * druhy.getJmenovatel();
        return new Zlomek(novyCitatel, novyJmenovatel);
    }

    public Zlomek odecti(Zlomek druhy) {
        int novyCitatel = citatel * druhy.getJmenovatel() - jmenovatel * druhy.getCitatel();
        int novyJmenovatel = jmenovatel * druhy.getJmenovatel();
        return new Zlomek(novyCitatel, novyJmenovatel);
    }

    public Zlomek vynasob(Zlomek druhy) {
        return new Zlomek(citatel * druhy.citatel, jmenovatel * druhy.jmenovatel);
    }

    public Zlomek vydel(Zlomek druhy) {
        return new Zlomek(citatel * druhy.jmenovatel, jmenovatel * druhy.citatel);
    }

    @Override
    public String toString() {
        return String.format("%d / %d", citatel, jmenovatel);
    }
}
