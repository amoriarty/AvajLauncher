package fr.alegent;

import java.util.HashSet;

class Tower {
    private HashSet<Flyable> observers = new HashSet<>();

    public void register(Flyable flyable) {
        observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
    }

    protected void conditionsChanged() {
        for (Flyable flyable: observers) {
            flyable.updateConditions();
        }
    }
}
