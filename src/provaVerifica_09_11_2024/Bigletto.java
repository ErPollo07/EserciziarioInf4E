package provaVerifica_09_11_2024;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Bigletto {
    public int numeroBiglietto;
    public ArrayList<Giostra> giostreFatte = new ArrayList<>();
    public ArrayList<LocalDate> dataDiEntrataInGiostra = new ArrayList<LocalDate>();
    public ArrayList<LocalTime> tempoDiEntrataInGiostra = new ArrayList<LocalTime>();
    public LocalTime tempoDiEntrata;

    @Override
    public String toString() {
        return String.format("Numero: %d, Giostre fatte: %s", numeroBiglietto, giostreFatte.toString());
    }
}
