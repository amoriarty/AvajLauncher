package fr.alegent;

interface Flyable {
    Boolean getUnregistered();
    String getType();
    void updateConditions();
    void registerTower(WeatherTower weatherTower);
}
