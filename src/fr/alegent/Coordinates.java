package fr.alegent;

class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    Coordinates(int longitude, int latitude, int height) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getHeight() {
        return height;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public void setHeight(int height) {
        if (height < 0) {
            this.height = 0;
        } else if (height > 100) {
            this.height = 100;
        } else {
            this.height = height;
        }
    }

    public void increaseLongitude(int by) {
        setLongitude(longitude + by);
    }

    public void increaseLatitude(int by) {
        setLatitude(latitude + by);
    }

    public void increaseHeight(int by) {
        setHeight(height + by);
    }

    public void decreaseHeight(int by) {
        setHeight(height - by);
    }
}
