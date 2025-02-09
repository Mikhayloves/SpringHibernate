package ru.example.SpringHibernate.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.example.SpringHibernate.entity.Recipe;

import java.util.List;

@Repository
public class RecipeDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Recipe recipe) {
        entityManager.persist(recipe);
    }

    @Transactional
    public void deleteById(int id) {
        Recipe recipe = entityManager.find(Recipe.class, id);
        if (recipe != null) {
            entityManager.remove(recipe);
        }
    }

    @Transactional(readOnly = true)
    public Recipe findById(int id) {
        return entityManager.find(Recipe.class, id);
    }

    @Transactional(readOnly = true)
    public List<Recipe> findByName(String name) {
        TypedQuery<Recipe> query = entityManager.createQuery(
                "SELECT r FROM Recipe r WHERE LOWER(r.name) LIKE LOWER(:name)", Recipe.class);
        query.setParameter("name", "%" + name + "%");
        return query.getResultList();
    }
}
