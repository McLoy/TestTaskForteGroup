package ua.vtkachenko.task.entities;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Parser {
    public void parseJSON(City city, String input) {
        JSONParser parser = new JSONParser();
        Double latitude, longitude;
        if (input != "") {
            try {
                Object obj = parser.parse(input);
                JSONObject json = (JSONObject) obj;
                JSONArray results = (JSONArray) json.get("results");
                if (results.size() != 0) {
                    JSONObject resultsEntry = (JSONObject) results.get(0);
                    JSONObject geometry = (JSONObject) resultsEntry.get("geometry");
                    JSONObject location = (JSONObject) geometry.get("location");
                    latitude = (Double) location.get("lat");
                    longitude = (Double) location.get("lng");
                    Location googleLocation = new Location(latitude, longitude);
                    city.setLocation(googleLocation);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}
