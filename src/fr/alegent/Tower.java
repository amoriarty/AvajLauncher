package fr.alegent;

import java.util.ArrayList;

class Tower {
    private ArrayList<Flyable> observers = new ArrayList<>();
    private ArrayList<Flyable> unregistered = new ArrayList<>();

    public void register(Flyable flyable) {
        Aircraft aircraft = (Aircraft)flyable;
        System.out.println("Tower says: " + flyable.getType() + "#" + aircraft.getName() + "(" + aircraft.getId() + ")" + " registered to weather tower.");
        observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        Aircraft aircraft = (Aircraft)flyable;
        System.out.println("Tower says: " + flyable.getType() + "#" + aircraft.getName() + "(" + aircraft.getId() + ")" + " unregistered to weather tower.");
        unregistered.add(flyable);
    }

    protected void conditionsChanged() {
        for (Flyable flyable: observers) {
            flyable.updateConditions();
            if (flyable.getUnregistered()) {
                unregister(flyable);
            }
        }

        for (Flyable flyable: unregistered) {
            observers.remove(flyable);
        }

        unregistered.removeAll(unregistered);
    }
}
