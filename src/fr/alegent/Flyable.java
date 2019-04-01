package fr.alegent;

interface Flyable {
    String getIdentifiable();
    Coordinates getCoordinates();
    void land();
    void updateConditions();
    void registerTower(WeatherTower weatherTower);
}
