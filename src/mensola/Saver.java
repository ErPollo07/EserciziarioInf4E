package mensola;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import garaAutomobilistica.Auto;
import garaAutomobilistica.Pilota;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Saver {
    public static class Json {
        private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
        private static final String SUFFIX = "_json.txt";

        public static void write(String path, Object obj) {
            String jsonContent = gson.toJson(obj);

            String filename = path + SUFFIX;

            try {
                Files.write(Paths.get(filename), jsonContent.getBytes());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        public static void write(String path, ArrayList<Object> objList) {
            String jsonContent = gson.toJson(objList);

            String filename = path + SUFFIX;

            try {
                Files.write(Paths.get(filename), jsonContent.getBytes());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        public static Object read(String path) {
            String filename = path + SUFFIX;

            try {
                FileReader reader = new FileReader(filename);

                Type type = new TypeToken<ArrayList<Auto>>(){}.getType();

                return gson.fromJson(reader, type);
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }

            return null;
        }
    }

    public static class Csv {
        private static final String SUFFIX = "_csv.txt";

        public static void write(String path, ArrayList<String> records) {
            String filename = path + SUFFIX;

            try {
                Files.write(Paths.get(filename), records);
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }

        public static ArrayList<Pilota> read(String path) {
            ArrayList<Pilota> output = new ArrayList<>();

            String filename = path + SUFFIX;

            try {
                ArrayList<String> linee = (ArrayList<String>)Files.readAllLines(Paths.get(filename));

                String[] attributi;
                for(String currentLinea : linee) {
                    attributi = currentLinea.split(";");

                    output.add(new Pilota(
                            attributi[0],
                            attributi[1],
                            attributi[2],
                            Integer.parseInt(attributi[3])
                    ));
                }
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }

            return output;
        }
    }
}
