package garaAutomobilistica;

public class Auto {
    private String scuderia;
    private Pilota pilota;
    private int cilindratra;

    public Auto(String scuderia, Pilota pilota, int cilindratra) {
        this.scuderia = scuderia;
        this.pilota = pilota;
        this.cilindratra = cilindratra;
    }

    public String getScuderia() {
        return scuderia;
    }

    public void setScuderia(String scuderia) {
        this.scuderia = scuderia;
    }

    public Pilota getPilota() {
        return pilota;
    }

    public void setPilota(Pilota pilota) {
        this.pilota = pilota;
    }

    public int getCilindratra() {
        return cilindratra;
    }

    public void setCilindratra(int cilindratra) {
        this.cilindratra = cilindratra;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Auto auto) {
            return this.pilota.equals(auto.getPilota()) && this.scuderia.equals(auto.getScuderia());
        }

        return false;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "scuderia='" + scuderia + '\'' +
                ", pilota=" + pilota +
                ", cilindratra=" + cilindratra +
                '}';
    }
}
