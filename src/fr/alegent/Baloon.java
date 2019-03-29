package fr.alegent;

class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;
    private Boolean unregistered = false;

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
                break;
            case "RAIN":
                System.out.println("Damn you rain! You messed up my baloon.");
                break;
            case "FOG":
                System.out.println("Can't see sh*t in this fog.");
                break;
            case "SNOW":
                System.out.println("It's snowing. We're  gonna crash.");
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
                coordinates.decreaseHeight(5);
                if (coordinates.getHeight() == 0) { land(); }
                return ;
            case "FOG":
                coordinates.decreaseHeight(3);
                if (coordinates.getHeight() == 0) { land(); }
                return ;
            case "SNOW":
                coordinates.decreaseHeight(3);
                if (coordinates.getHeight() == 0) { land(); }
                return ;
            case "SUN":
                coordinates.increaseLongitude(12);
                coordinates.increaseHeight(4);
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
