package fr.alegent;

class AircraftFactory {

    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws TypeException {
        Coordinates coordinates = new Coordinates(longitude, latitude, height);

        switch (type) {
            case "Baloon": return new Baloon(name, coordinates);
            case "JetPlane": return new JetPlane(name, coordinates);
            case "Helicopter": return new Helicopter(name, coordinates);
        }

        throw new TypeException();
    }

    public class TypeException extends Exception {
        @Override
        public String toString() {
            return "Error: AircraftFactory: Invalid aircraft type passed to factory.";
        }
    }
}
