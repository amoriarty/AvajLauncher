package fr.alegent;

import java.util.HashSet;

class Tower {
    private HashSet<Flyable> observers = new HashSet<>();

    public void register(Flyable flyable) {
        Aircraft aircraft = (Aircraft)flyable;
        System.out.println("Tower says: " + flyable.getType() + "#" + aircraft.getName() + "(" + aircraft.getId() + ")" + " registered to weather tower.");
        observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        Aircraft aircraft = (Aircraft)flyable;
        System.out.println("Tower says: " + flyable.getType() + "#" + aircraft.getName() + "(" + aircraft.getId() + ")" + " unregistered to weather tower.");
        observers.remove(flyable);
    }

    protected void conditionsChanged() {
        for (Flyable flyable: observers) {
            flyable.updateConditions();
        }
    }
}
