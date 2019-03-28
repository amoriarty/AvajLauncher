package fr.alegent;

class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public String getType() {
        return "Helicopter";
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        System.out.print(getType() + "#" + getName() + "(" + getId() + "): ");

        switch (weather) {
            case "SUN":
                System.out.println("This is hot.");
                return;
            case "RAIN":
                System.out.println("Did you get windscreen wipers?");
                return;
            case "FOG":
                System.out.println("My pals will cut that like butter!");
                return;
            case "SNOW":
                System.out.println("My rotor is going to freeze!");
                return;
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        weatherTower.register(this);
        this.weatherTower = weatherTower;
    }
}
