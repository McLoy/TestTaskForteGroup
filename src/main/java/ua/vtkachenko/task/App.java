package ua.vtkachenko.task;

import ua.vtkachenko.task.entities.LocationService;

public class App {
    public static void main(String[] args) {
        LocationService locationService = new LocationService("Data.txt");
        locationService.locationByName();
    }
}
