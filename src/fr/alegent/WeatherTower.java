package fr.alegent;

class WeatherTower extends Tower {

    public String getWeather(Coordinates coordinates) {
        WeatherProvider provider = WeatherProvider.getProvider();
        return provider.getCurrentWeather(coordinates);
    }

    void changeWeather() {
        super.conditionsChanged();
    }
}
