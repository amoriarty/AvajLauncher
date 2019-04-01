package fr.alegent;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
        type = "JetPlane";
    }

    public void registerTower(WeatherTower weatherTower) {
        weatherTower.register(this);
        this.weatherTower = weatherTower;
    }

    public void updateConditions() {
        super.updateConditions();
        String weather = weatherTower.getWeather(coordinates);

        switch (weather) {
            case "SUN":
                System.out.println("You forget sun cream, we are cooked!");
                coordinates.increaseLatitude(10);
                coordinates.increaseHeight(2);
                break;
            case "RAIN":
                System.out.println("It's raining. Better watch out for lightings.");
                coordinates.increaseLatitude(5);
                break;
            case "FOG":
                System.out.println("Seems foggy down there, but never from where we stand.");
                coordinates.increaseLatitude(1);
                break;
            case "SNOW":
                System.out.println("OMG! Winter is coming!");
                coordinates.decreaseHeight(7);
                break;
        }
    }
}
