package fr.alegent;

class Aircraft {
    protected long id;
    protected String type;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter = 0;

    protected Aircraft(String name, Coordinates coordinates) {
        this.id = nextId();
        this.name = name;
        this.coordinates = coordinates;
    }

    private long nextId() {
        return ++idCounter;
    }

    public String getIdentifiable() {
        return type + "#" + name + "(" + id + ")";
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void land() {
        System.out.println(getIdentifiable() + " landing.");
    }

    protected void updateConditions() {
        System.out.print(getIdentifiable() + ": ");
    }
}
