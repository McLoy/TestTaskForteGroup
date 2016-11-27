package ua.vtkachenko.task.entities;

public class City implements Comparable{

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return name != null ? name.equals(city.name) : city.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public int compareTo(Object o) {
        if (o != null){
            if (o.getClass() == City.class){
                String destName = ((City)o).getName();
                return name.hashCode() > destName.hashCode() ? 1 : name.hashCode() == destName.hashCode() ? 0 : -1;
            }
        }
        return 0;
    }
}
