package solidi;

import java.util.ArrayList;

public class GestoreSolidi {
    private int NMAX;
    private ArrayList<Solido> solidi;

    public GestoreSolidi(int NMAX) {
        this.NMAX = NMAX;
        this.solidi = new ArrayList<>();
    }

    public void add(Solido solido) {
        solidi.add(solido);
    }

    public boolean isFull() {
        return solidi.size() == NMAX;
    }

    public ArrayList<Solido> getSolidi() {
        return solidi;
    }
}
