package ua.vtkachenko.task.entities;

import ua.vtkachenko.task.dao.CityDao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LocationService {

    private static final String ENCODING = "US-ASCII";
    private static final String GOOGLE_SERVICE_URL = "https://maps.googleapis.com/maps/api/geocode/json?sensor=false&address=";
    private List<City> list;
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

    public ArrayList<String> locationByName(){
        CityDao cityDao = new CityDao();
        List<City> allData = cityDao.getAll(nameOfFile);
        Parser parser = new Parser();
        ArrayList<String> stringResultList = new ArrayList<String>();
        String resultString;
        for (int i = 0; i < allData.size(); i++) {
            City currentCity = allData.get(i);
            String respString = getJSONAnswer(currentCity);
            parser.parseJSON(currentCity, respString);
            String city = currentCity.getName();
            if (currentCity.getLocation() != null) {
                resultString = city + " " + currentCity.getLocation().getLatitude()
                        + " (latitude), " + currentCity.getLocation().getLongitude() + " (longitude)";
            } else {
                resultString = "For '" + city + "' location not found.";
            }
            stringResultList.add(resultString);
        }
        stringResultList.stream().forEach(System.out::println);
        return stringResultList;
    }
}
