package fr.alegent;

import java.util.Date;
import java.util.Random;

class WeatherProvider {
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private static String[] weather = { "RAIN", "SNOW", "FOG", "SUN" };

    WeatherProvider() { }

    public static WeatherProvider getProvider() {
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int index = 0;
        int now = (int) new Date().getTime();
        int seed = new Random(now).nextInt();
        seed = new Random(coordinates.getLatitude() + seed).nextInt();
        seed = new Random(coordinates.getLatitude() + seed).nextInt();
        seed = new Random(coordinates.getHeight() - seed).nextInt();
        index = new Random(seed).nextInt(4);
        return weather[index];
    }
}
