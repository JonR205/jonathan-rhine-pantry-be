package net.yorksolutions.jonathanrhinepantrybe.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Pantry {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Ingredient> ingredients;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Recipe> recipes;

    public Pantry() {
    }

    public Pantry(Long id, List<Ingredient> ingredients, List<Recipe> recipes) {
        this.id = id;
        this.ingredients = ingredients;
        this.recipes = recipes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }
}
