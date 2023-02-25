package net.yorksolutions.jonathanrhinepantrybe.repositories;

import net.yorksolutions.jonathanrhinepantrybe.entity.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long> {

    public Optional<Recipe> findIngredientByName(String name);
}
