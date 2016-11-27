package ua.vtkachenko.task.entities;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class LocationService {

    public static final String GOOGLE_SERVICE_URL = "https://maps.googleapis.com/maps/api/geocode/json?sensor=false&address=";

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
}
