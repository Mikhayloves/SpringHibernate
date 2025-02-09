package ru.example.SpringHibernate.service;

import ru.example.SpringHibernate.entity.Recipe;

import java.util.List;

public interface RecipeService {
    void insert(Recipe recipe);
    void delete(String name);
    List<Recipe> findByName(String name);
}
