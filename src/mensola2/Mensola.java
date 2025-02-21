package mensola2;

import mensola2.libri.Libro;

import java.util.ArrayList;

public class Mensola {
    private int numeroLibri;
    private int maxLibri;
    private ArrayList<Libro> mensola = new ArrayList<>();

    public Mensola(int maxLibri){
        this.maxLibri = maxLibri;
    }

    public boolean isAvaible() {
        return mensola.size() < maxLibri;
    }

    public int getNumeroLibri() {
        return numeroLibri;
    }

    public ArrayList<Libro> getMensola() {
        return mensola;
    }

    public boolean addLibro(Libro l) {
        if (mensola.size() < maxLibri) {
            return mensola.add(l);
        }

        return false;
    }

    public void addLibro(Libro l, int i) {
        if (mensola.size() < maxLibri) {
            mensola.add(i, l);
        }
    }

    public void remove(Libro l) {
        mensola.remove(l);
    }
}
