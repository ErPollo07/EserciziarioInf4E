package solidi;

public class Cubo extends Solido {
    private double lato;

    public Cubo(double lato) {
        super("Cubo");
        this.lato = lato;
    }

    public double getLato() {
        return lato;
    }

    @Override
    public double calcolaSuperficie() {
        return 6 * Math.pow(this.lato, 2);
    }

    @Override
    public double calcolaVolume() {
        return Math.pow(this.lato, 3);
    }
}
