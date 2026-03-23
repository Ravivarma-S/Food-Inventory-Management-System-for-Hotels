package com.example.hotelinventory.model;

import jakarta.persistence.*;

@Entity
@Table(name="ingrediants")
public class IngredientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ingName;
    private String ingUnit;
    private String ingQty;
    private String ingNote;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private RecipeEntity recipe;

    public Long getId() {
        return id;
    }

    public String getIngName() {
        return ingName;
    }

    public void setIngName(String ingName) {
        this.ingName = ingName;
    }

    public String getIngUnit() {
        return ingUnit;
    }

    public void setIngUnit(String ingUnit) {
        this.ingUnit = ingUnit;
    }

    public String getIngQty() {
        return ingQty;
    }

    public void setIngQty(String ingQty2) {
        this.ingQty = ingQty2;
    }

    public String getIngNote() {
        return ingNote;
    }

    public void setIngNote(String ingNote) {
        this.ingNote = ingNote;
    }

    public RecipeEntity getRecipe() {
        return recipe;
    }

    public void setRecipe(RecipeEntity recipe) {
        this.recipe = recipe;
    }
}
