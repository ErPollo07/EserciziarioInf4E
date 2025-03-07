package solidi;

public abstract class Solido {
    protected String nome;

    public Solido(String nome) {
        this.nome = nome;
    }

    public abstract double calcolaVolume();
    public abstract double calcolaSuperficie();

    @Override
    public String toString() {
        return String.format("%s [Volume; %.2f cm3, Superficie: %.2f]", nome, calcolaVolume(), calcolaSuperficie());
    }
}
