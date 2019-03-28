package fr.alegent;

import java.util.HashMap;

class WeatherProvider {
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private static HashMap<Coordinates, String> weather = new HashMap<>();

    WeatherProvider() { }

    public static WeatherProvider getProvider() {
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        return weather.computeIfAbsent(coordinates, coordinates1 -> newWeather());
    }

    // TODO: Generate random weather.
    private String newWeather() {
        return "SUN";
    }
}
