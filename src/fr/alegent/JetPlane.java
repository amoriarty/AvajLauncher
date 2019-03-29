package fr.alegent;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;
    private Boolean unregistered = false;

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
                break;
            case "RAIN":
                System.out.println("It's raining. Better watch out for lightings.");
                break;
            case "FOG":
                System.out.println("Seems foggy down there, but never from where we stand.");
                break;
            case "SNOW":
                System.out.println("OMG! Winter is coming!");
                break;
        }

        changeCoordinates(weather);
    }

    public void registerTower(WeatherTower weatherTower) {
        weatherTower.register(this);
        this.weatherTower = weatherTower;
    }

    private void changeCoordinates(String weather) {
        switch (weather) {
            case "RAIN":
                coordinates.increaseLatitude(5);
                return ;
            case "FOG":
                coordinates.increaseLatitude(1);
                return ;
            case "SNOW":
                coordinates.decreaseHeight(7);
                if (coordinates.getHeight() == 0) { land(); }
                return ;
            case "SUN":
                coordinates.increaseLatitude(10);
                coordinates.increaseHeight(2);
                return ;
        }
    }

    private void land() {
        System.out.println(getType() + "#" + getName() + "(" + getId() + ") landing.");
        unregistered = true;
    }

    public Boolean getUnregistered() {
        return unregistered;
    }
}
