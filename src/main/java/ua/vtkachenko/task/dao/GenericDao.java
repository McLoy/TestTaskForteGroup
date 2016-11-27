package ua.vtkachenko.task.dao;

import ua.vtkachenko.task.entities.City;

import java.util.List;

public interface GenericDao {
    List<City> getAll(String name);
}
