package ua.vtkachenko.task.entities;

import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

public class ParserTest {

    private City city;
    private LocationService locationService;
    private static final String FILE_PATH = "Data.txt";

    @Before
    public void setUp(){
        city = new City("London");
    }

    @Test
    public void emptyString() throws Exception {
        Parser parser = new Parser();
        parser.parseJSON(city, "");
        Assertions.assertThat(city.getLocation()).isNull();
    }

    @Test
    public void parseJSON() throws Exception {
        Parser parser = new Parser();
        locationService = new LocationService(FILE_PATH);
        parser.parseJSON(city, locationService.getJSONAnswer(city));
        Assertions.assertThat(city.getLocation()).isNotNull();
    }
}
