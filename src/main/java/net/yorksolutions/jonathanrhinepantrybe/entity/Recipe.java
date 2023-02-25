package net.yorksolutions.jonathanrhinepantrybe.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;

    //    to add file upload https://www.codejava.net/frameworks/spring-boot/spring-boot-file-upload-tutorial
    @ElementCollection
    private List<String> steps;

    private String imageURL;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Ingredient> ingredients;

    private Integer calories;

    private Long accountId;

    public Recipe() {
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Recipe(Long id, String name, List<String> steps, String imageURL, List<Ingredient> ingredients, Integer calories, Long accountId) {
        this.id = id;
        this.name = name;
        this.steps = steps;
        this.imageURL = imageURL;
        this.ingredients = ingredients;
        this.calories = calories;
        this.accountId = accountId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSteps() {
        return steps;
    }

    public void setSteps(List<String> steps) {
        this.steps = steps;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }
}


