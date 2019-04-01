package fr.alegent;

import java.util.ArrayList;

class Tower {
    private ArrayList<Flyable> observers = new ArrayList<>();

    public void register(Flyable flyable) {
        System.out.println("Tower says: " + flyable.getIdentifiable() + " registered to weather tower.");
        observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        System.out.println("Tower says: " + flyable.getIdentifiable() + " unregistered to weather tower.");
    }

    protected void conditionsChanged() {
        for (Flyable flyable: observers) {
            flyable.updateConditions();
            if (flyable.getCoordinates().getHeight() == 0) {
                flyable.land();
                unregister(flyable);
            }
        }

        observers.removeIf(flyable -> flyable.getCoordinates().getHeight() == 0);
    }
}
