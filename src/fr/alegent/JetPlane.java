package fr.alegent;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public String getType() {
        return "JetPlane";
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        System.out.print(getType() + "#" + getName() + "(" + getId() + "): ");

        switch (weather) {
            case "SUN":
                System.out.println("You forget sun cream, we are cooked!");
                return;
            case "RAIN":
                System.out.println("It's raining. Better watch out for lightings.");
                return;
            case "FOG":
                System.out.println("Seems foggy down there, but never from where we stand.");
                return;
            case "SNOW":
                System.out.println("OMG! Winter is coming!");
                return;
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        weatherTower.register(this);
        this.weatherTower = weatherTower;
    }
}
