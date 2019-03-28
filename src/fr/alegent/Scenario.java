package fr.alegent;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Scenario {
    int simulations;
    ArrayList<Flyable> flyables = new ArrayList<>();

    Scenario(String file) throws Exception {
        Path path = Paths.get(file);
        List<String> lines = Files.readAllLines(path);
        AircraftFactory factory = new AircraftFactory();

        try {
            this.simulations = Integer.parseInt(lines.get(0));
            lines.remove(0);

            for (String line: lines) {
                String[] splitted = line.split(" ");
                Flyable flyable = parse(factory, splitted);
                this.flyables.add(flyable);
            }
        } catch (Exception e) {
            throw new ParsingException();
        }
    }

    Flyable parse(AircraftFactory factory, String[] splitted) throws Exception {
        String type = splitted[0];
        String name = splitted[1];
        int longitude = Integer.parseInt(splitted[2]);
        int latitude = Integer.parseInt(splitted[3]);
        int height = Integer.parseInt(splitted[4]);
        return factory.newAircraft(type, name, longitude, latitude, height);
    }

    public class ParsingException extends Exception {
        @Override
        public String toString() {
            return "Error: Scenario: Scenario file is incorrect.";
        }
    }
}
