package ua.vtkachenko.task.entities;

public class City {

    private String name;
    private Location location;

    public City(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
