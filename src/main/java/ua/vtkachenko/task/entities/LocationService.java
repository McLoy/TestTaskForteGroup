package ua.vtkachenko.task.entities;

import ua.vtkachenko.task.dao.CityDao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

public class LocationService {

    public static final String GOOGLE_SERVICE_URL = "https://maps.googleapis.com/maps/api/geocode/json?sensor=false&address=";
    private String nameOfFile;

    public LocationService(String nameOfFile) {
        this.nameOfFile = nameOfFile;
    }

    public String getJSONAnswer(City currentCity) {
        String link =  GOOGLE_SERVICE_URL + currentCity.getName();
        String answer = "";
        try {
            URL url = new URL(link);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String strTemp;
            while (null != (strTemp = br.readLine())) {
                answer = answer + strTemp;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return answer;
    }

    public void locationByName(){
        CityDao cityDao = new CityDao();
        List<City> allData = cityDao.getAll(nameOfFile);
        Parser parser = new Parser();
        for (int i = 0; i < allData.size(); i++) {
            City currentCity = allData.get(i);
            String respString = getJSONAnswer(currentCity);
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
