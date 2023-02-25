package net.yorksolutions.jonathanrhinepantrybe.services;

import net.yorksolutions.jonathanrhinepantrybe.entity.Ingredient;
import net.yorksolutions.jonathanrhinepantrybe.repositories.IngredientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class IngredientService {

    private IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }


    public ResponseEntity<Ingredient> addIngredient(Ingredient ingredientRequest) throws Exception {
        if (ingredientRepository.findIngredientByName(ingredientRequest.getName()).isPresent())
            throw new Exception();

        if (ingredientRequest.getName().equals(null)) {
            throw new Exception();
        }

        return new ResponseEntity<>(ingredientRepository.save(ingredientRequest), HttpStatus.OK);
    }

    public Ingredient getIngredientById(Long id) {
        return ingredientRepository.findById(id).orElse(null);
    }

    public Ingredient getIngredientByName(String name) {
        return ingredientRepository.findIngredientByName(name).orElse(null);

    }

    public void deleteById(Long id) {
        Optional<Ingredient> ingredientOpt = ingredientRepository.findById(id);



        ingredientRepository.deleteById(id);
    }

    public void editIngredient(Long id, Ingredient ingredientRequest) {
            Optional<Ingredient> ingredientOpt = this.ingredientRepository.findById(id);
        if (ingredientOpt.isEmpty()) {
            throw new ResponseStatusException((HttpStatus.NOT_FOUND));
        }
        ingredientRepository.save(ingredientRequest);
    }

    public Iterable<Ingredient> getAllIngredient() throws Exception {
        try {
            Iterable<Ingredient> ingredientList = ingredientRepository.findAll();
            return ingredientList;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
