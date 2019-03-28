package fr.alegent;

public class Main {

    public static void main(String[] args) {
        AircraftFactory factory = new AircraftFactory();

        try {
            Flyable baloon = factory.newAircraft("Baloon", "baloon", 1, 1, 1);
            Flyable jetPlane = factory.newAircraft("JetPlane", "jetplane", 2, 2, 2);
            Flyable helicopter = factory.newAircraft("Helicopter", "helicopter", 3, 4, 5);
        } catch (AircraftFactory.TypeException e) {
            System.out.println(e.toString());
        }
    }
}
