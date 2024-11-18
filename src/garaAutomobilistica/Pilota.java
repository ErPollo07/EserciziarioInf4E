package garaAutomobilistica;

public class Pilota {
    private String nome;
    private String cognome;
    private String nazionalita;
    private int eta;

    public Pilota(String name, String surname, String nationality, int eta) {
        this.nome = name;
        this.cognome = surname;
        this.nazionalita = nationality;
        this.eta = eta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNazionalita() {
        return nazionalita;
    }

    public void setNazionalita(String nazionalita) {
        this.nazionalita = nazionalita;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Pilota pilota) {
            return this.nome.equals(pilota.getNome()) && this.cognome.equals(pilota.getCognome()) && this.eta == pilota.getEta();
        }

        return false;
    }

    @Override
    public String toString() {
        return "Pilota {" +
                "name = '" + nome + "'" +
                ", surname = '" + cognome + "'" +
                ", nationality = '" + nazionalita + "'" +
                ", eta = " + eta +
                '}';
    }
}
