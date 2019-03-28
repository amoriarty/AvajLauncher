package fr.alegent;

class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public String getType() {
        return "Baloon";
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        System.out.print(getType() + "#" + getName() + "(" + getId() + "): ");

        switch (weather) {
            case "SUN":
                System.out.println("Let's enjoy the good weather and take some pics.");
                return;
            case "RAIN":
                System.out.println("Damn you rain! You messed up my baloon.");
                return;
            case "FOG":
                System.out.println("Can't see sh*t in this fog.");
                return;
            case "SNOW":
                System.out.println("It's snowing. We're  gonna crash.");
                return;
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        weatherTower.register(this);
        this.weatherTower = weatherTower;
    }
}
