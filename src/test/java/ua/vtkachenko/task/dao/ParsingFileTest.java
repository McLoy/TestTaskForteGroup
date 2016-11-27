package ua.vtkachenko.task.dao;

import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;
import ua.vtkachenko.task.entities.City;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ParsingFileTest {

    private List<City> sourceList;

    @Before
    public void setUp(){
        sourceList = new ArrayList<>();
        sourceList.add(new City("Kiev"));
        sourceList.add(new City("Lviv"));
        sourceList.add(new City("Ternopil"));
    }

    @Test
    public void equalLists() throws Exception {
        CityDao cityDao = new CityDao();
        List<City> destinationList = cityDao.getAll("Data.txt");
        Assertions.assertThat(equalLists(destinationList, sourceList)).isTrue();
    }

    @Test
    public void notEqualLists() throws Exception {
        CityDao cityDao = new CityDao();
        List<City> destinationList = cityDao.getAll("Data.txt");
        sourceList.add(new City("London"));
        Assertions.assertThat(equalLists(destinationList, sourceList)).isFalse();
    }

    public  boolean equalLists(List<City> a, List<City> b){
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
