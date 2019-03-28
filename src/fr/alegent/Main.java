package fr.alegent;

public class Main {

    public static void main(String[] args) {
        WeatherTower tower = new WeatherTower();
        Scenario scenario;

        if (args.length == 0) {
            System.err.println("Error: Main: You have to passed a scenario file as parameter.");
            return;
        }

        try {
            scenario = new Scenario(args[0]);

            for (Flyable flyable: scenario.flyables) {
                flyable.registerTower(tower);
            }

            for (int i = 0; i <= scenario.simulations; i++) {
                tower.changeWeather();
            }

        } catch (Exception e) {
            System.err.println(e.toString());
        }

    }
}
