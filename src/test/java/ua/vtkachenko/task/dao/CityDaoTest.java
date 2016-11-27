package ua.vtkachenko.task.dao;

import org.junit.Test;
import ua.vtkachenko.task.entities.City;
import org.fest.assertions.*;
import java.util.List;

public class CityDaoTest {

    @Test
    public void getAll() throws Exception {
        CityDao cityDao = new CityDao();
        List<City> list = cityDao.getAll();
        Assertions.assertThat(list).isNotNull();
    }
}
