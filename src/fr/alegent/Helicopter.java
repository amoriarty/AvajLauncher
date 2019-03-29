package fr.alegent;

class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;
    private Boolean unregistered = false;

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
                break;
            case "RAIN":
                System.out.println("Did you get windscreen wipers?");
                break;
            case "FOG":
                System.out.println("My pals will cut that like butter!");
                break;
            case "SNOW":
                System.out.println("My rotor is going to freeze!");
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
                coordinates.increaseLongitude(5);
                return ;
            case "FOG":
                coordinates.increaseLongitude(1);
                return ;
            case "SNOW":
                coordinates.decreaseHeight(12);
                if (coordinates.getHeight() == 0) { land(); }
                return ;
            case "SUN":
                coordinates.increaseLongitude(10);
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
