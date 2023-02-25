package net.yorksolutions.jonathanrhinepantrybe.controllers;

import net.yorksolutions.jonathanrhinepantrybe.entity.Account;
import net.yorksolutions.jonathanrhinepantrybe.entity.Ingredient;
import net.yorksolutions.jonathanrhinepantrybe.entity.Recipe;
import net.yorksolutions.jonathanrhinepantrybe.services.RecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/recipes")
@CrossOrigin
public class RecipeController {
    private RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/{id}")
    public Recipe getRecipeById(@PathVariable Long id) {
        return recipeService.getAccountById(id);
    }

    @GetMapping
    public Iterable<Recipe> getAllRecipe() {
        try {
            return recipeService.getAllRecipes();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED);
        }
    }

    @PostMapping
    public void addRecipe(@RequestBody Recipe recipeRequest) {
        try {
            recipeService.addRecipe(recipeRequest);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteRecipeById(@PathVariable Long id) {
        try {
            recipeService.deleteById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public void editRecipe(@PathVariable Long id, @RequestBody Recipe recipeRequest) {
        try {
            recipeService.editIngredient(id, recipeRequest);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }


}
