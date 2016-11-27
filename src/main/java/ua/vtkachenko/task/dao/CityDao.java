package ua.vtkachenko.task.dao;

import ua.vtkachenko.task.entities.City;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CityDao implements GenericDao {

    private List<City> list;
    private static final String ENCODING = "US-ASCII";

    public List<City> getAll(String fileName) {
        list = new ArrayList<>();
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource != null) {
        Path data = Paths.get(resource.getFile()).toAbsolutePath();
            Charset charset = Charset.forName(ENCODING);
            try (BufferedReader reader = Files.newBufferedReader(data, charset)) {
                String line;
                while ((line = reader.readLine()) != null) {
                    City city = new City(line);
                    list.add(city);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
