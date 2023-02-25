package net.yorksolutions.jonathanrhinepantrybe.repositories;

import net.yorksolutions.jonathanrhinepantrybe.entity.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {

    public Optional<Ingredient> findIngredientByName(String name);
}
