package net.yorksolutions.jonathanrhinepantrybe.controllers;

import net.yorksolutions.jonathanrhinepantrybe.entity.Ingredient;
import net.yorksolutions.jonathanrhinepantrybe.services.IngredientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/ingredients")
@CrossOrigin
public class IngredientController {
    private IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PostMapping
    public void addIngredient(@RequestBody Ingredient ingredientRequest) {
        try {
            ingredientService.addIngredient(ingredientRequest);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED);
        }
    }


    @GetMapping("/{id}")
    public Ingredient getIngredientById(@PathVariable Long id) {
        return ingredientService.getIngredientById(id);
    }

    @GetMapping
    public Iterable<Ingredient> getAllIngredient() {
        try {
            return ingredientService.getAllIngredient();
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteIngredientById(@PathVariable Long id) {
        try {
            ingredientService.deleteById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public void editIngredient(@PathVariable Long id, @RequestBody Ingredient ingredientRequest){
        try {
            ingredientService.editIngredient(id, ingredientRequest);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }



}
