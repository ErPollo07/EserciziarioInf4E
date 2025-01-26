package garaAutomobilistica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class Gara {
    public static ArrayList<Pilota> risultato = new ArrayList<>();
    public static String nome = "Nome gara";
    public static ArrayList<Auto> automobili = new ArrayList<>();

    public static void corriGara(ArrayList<Pilota> pilotaArrayList) {
        assignPilotToCar(pilotaArrayList);

        Collections.shuffle(automobili);

        // For every car in automobili get the pilot
        // collect all the pilot in a list and store it as the result of the race
        risultato = (ArrayList<Pilota>) automobili.stream().map(Auto::getPilota).collect(Collectors.toList());
    }

    public static void assignPilotToCar(ArrayList<Pilota> pilotaArrayList) {
        automobili = new ArrayList<>(pilotaArrayList.size());

        for (int i = 0; i < pilotaArrayList.size(); i++) {
            automobili.add(new Auto("Ferrari", pilotaArrayList.get(i), 5));
        }
    }
}
