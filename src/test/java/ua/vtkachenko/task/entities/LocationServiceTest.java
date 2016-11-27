package ua.vtkachenko.task.entities;

import org.fest.assertions.Assertions;
import org.junit.Test;

public class LocationServiceTest {

    @Test
    public void getJSONAnswer() throws Exception {
        String name = "fsdfgsfdhs";
        City city = new City(name);
        LocationService locationService = new LocationService("Data.txt");
        Assertions.assertThat(locationService.getJSONAnswer(city)).isNotEqualTo("");
    }

}
