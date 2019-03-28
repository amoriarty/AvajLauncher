package fr.alegent;

interface Flyable {
    String getType();
    void updateConditions();
    void registerTower(WeatherTower weatherTower);
}
