package net.yorksolutions.jonathanrhinepantrybe.services;

import net.yorksolutions.jonathanrhinepantrybe.entity.Ingredient;
import net.yorksolutions.jonathanrhinepantrybe.entity.Recipe;
import net.yorksolutions.jonathanrhinepantrybe.repositories.IngredientRepository;
import net.yorksolutions.jonathanrhinepantrybe.repositories.RecipeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {
    private RecipeRepository recipeRepository;
    private IngredientRepository ingredientRepository;
    public RecipeService(RecipeRepository recipeRepository, IngredientRepository ingredientRepository) {
        this.recipeRepository = recipeRepository;
        this.ingredientRepository = ingredientRepository;
    }

    public Recipe getAccountById(Long id) {
        return recipeRepository.findById(id).orElse(null);
    }

    public Iterable<Recipe> getAllRecipes() throws Exception {
        try {
            Iterable<Recipe> recipeList = recipeRepository.findAll();

            return recipeList;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Recipe> addRecipe(Recipe recipeRequest) throws Exception {
        if (recipeRepository.findIngredientByName(recipeRequest.getName()).isPresent())
            throw new Exception();

        if (recipeRequest.getName().equals(null)) {
            throw new Exception();
        }

        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepository.saveAll(recipeRequest.getIngredients()).forEach(ingredients::add);
        recipeRequest.setIngredients(ingredients);
        return new ResponseEntity<>(recipeRepository.save(recipeRequest), HttpStatus.OK);
    }

    public void deleteById(Long id) {

        Optional<Recipe> ingredientOpt = recipeRepository.findById(id);


        recipeRepository.deleteById(id);
    }


    public void editIngredient(Long id, Recipe recipeRequest) {

        Optional<Recipe> recipeOpt = this.recipeRepository.findById(id);
        if (recipeOpt.isEmpty()) {
            throw new ResponseStatusException((HttpStatus.NOT_FOUND));
        }
        recipeRepository.save(recipeRequest);
    }
}
