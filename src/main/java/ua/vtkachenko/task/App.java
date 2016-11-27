package ua.vtkachenko.task;

import ua.vtkachenko.task.dao.CityDao;
import ua.vtkachenko.task.entities.City;
import ua.vtkachenko.task.entities.LocationService;
import ua.vtkachenko.task.entities.Parser;

import java.util.List;

public class App {
    public static void main(String[] args) {
        CityDao cityDao = new CityDao();
        List<City> allData = cityDao.getAll();
        LocationService locationService = new LocationService();
        Parser parser = new Parser();
        for (int i = 0; i < allData.size(); i++) {
            City currentCity = allData.get(i);
            String respString = locationService.getJSONAnswer(currentCity);
            parser.parseJSON(currentCity, respString);
            String city = currentCity.getName();
            if (currentCity.getLocation() != null) {
                System.out.println(city + " " + currentCity.getLocation().getLatitude()
                        + " (latitude), " + currentCity.getLocation().getLongitude() + " (longitude)");
            } else {
                System.out.println("For '" + city + "' location not found.");
            }
        }
    }
}
