package ru.example.SpringHibernate.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.example.SpringHibernate.entity.Recipe;
import ru.example.SpringHibernate.repo.RecipeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    @Transactional
    @Override
    public void insert(Recipe recipe) {
        recipeRepository.save(recipe);
    }

    @Transactional
    @Override
    @SuppressWarnings("unchecked")
    public void delete(String name) {
        List<Recipe> recipes = recipeRepository.findByNameContainingIgnoreCase(name);
        recipes.forEach(recipeRepository::delete);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Recipe> findByName(String name) {
        return recipeRepository.findByNameContainingIgnoreCase(name);
    }
}