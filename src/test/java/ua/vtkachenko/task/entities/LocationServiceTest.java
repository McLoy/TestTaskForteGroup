package ua.vtkachenko.task.entities;

import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LocationServiceTest {

    private LocationService locationService;
    private List<String> sourceList;
    private static final String FILE_PATH = "Data.txt";

    @Before
    public void setUp(){
        locationService = new LocationService(FILE_PATH);
        sourceList = new ArrayList<>();
        sourceList.add("Kiev 50.4501 (latitude), 30.5234 (longitude)");
        sourceList.add("Lviv 49.839683 (latitude), 24.029717 (longitude)");
        sourceList.add("Ternopil 49.553517 (latitude), 25.594767 (longitude)");
    }

    @Test
    public void getJSONAnswer() throws Exception {
        String name = "fsdfgsfdhs";
        City city = new City(name);
        Assertions.assertThat(locationService.getJSONAnswer(city)).isNotEqualTo("");
    }

    @Test
    public void locationByName() throws Exception {
        List<String> destList = locationService.locationByName();
        Assertions.assertThat(equalStringLists(destList, sourceList)).isTrue();
    }

    public boolean equalStringLists(List<String> a, List<String> b){
        if ((a.size() != b.size()) || (a == null && b!= null) || (a != null && b== null)){
            return false;
        }
        if (a == null && b == null) {
            return true;
        }
        Collections.sort (a);
        Collections.sort (b);
        return a.equals(b);
    }
}
