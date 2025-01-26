package garaAutomobilistica;

import com.google.gson.JsonObject;

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

    public JsonObject toJson() {
        JsonObject obj = new JsonObject();

        obj.addProperty("nome", nome);
        obj.addProperty("cognome", cognome);
        obj.addProperty("nazionalita", nazionalita);
        obj.addProperty("eta", eta);

        return obj;
    }

    public String toCsv() {
        return String.format("%s;%s;%s;%d", nome, cognome, nazionalita, eta);
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
