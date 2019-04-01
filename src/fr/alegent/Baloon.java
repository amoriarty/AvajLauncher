package fr.alegent;

class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
        type = "Baloon";
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
                System.out.println("Let's enjoy the good weather and take some pics.");
                coordinates.increaseLongitude(12);
                coordinates.increaseHeight(4);
                break;
            case "RAIN":
                System.out.println("Damn you rain! You messed up my baloon.");
                coordinates.decreaseHeight(5);
                break;
            case "FOG":
                System.out.println("Can't see sh*t in this fog.");
                coordinates.decreaseHeight(3);
                break;
            case "SNOW":
                System.out.println("It's snowing. We're  gonna crash.");
                coordinates.decreaseHeight(3);
                break;
        }
    }
}
