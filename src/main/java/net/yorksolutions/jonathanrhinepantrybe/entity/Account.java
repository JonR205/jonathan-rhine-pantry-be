package net.yorksolutions.jonathanrhinepantrybe.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String username;
    private String password;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Recipe> recipes;

    public Account() {
    }

    public Account(Long id, String username, String password, List<Recipe> recipes) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.recipes = recipes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setCRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }
}
