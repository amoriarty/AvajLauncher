package fr.alegent;

class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
        type = "Helicopter";
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
                System.out.println("This is hot.");
                coordinates.increaseLongitude(10);
                coordinates.increaseHeight(2);
                break;
            case "RAIN":
                System.out.println("Did you get windscreen wipers?");
                coordinates.increaseLongitude(5);
                break;
            case "FOG":
                System.out.println("My pals will cut that like butter!");
                coordinates.increaseLongitude(1);
                break;
            case "SNOW":
                System.out.println("My rotor is going to freeze!");
                coordinates.decreaseHeight(12);
                break;
        }
    }
}
