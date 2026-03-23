package com.example.hotelinventory.service;

import com.example.hotelinventory.model.*;
import com.example.hotelinventory.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    public void saveRecipe(String dishName,
                           String preparationNotes,
                           String[] ingName,
                           String[] ingUnit,
                           double[] ingQty,
                           String[] ingNote) {

        RecipeEntity recipe = new RecipeEntity();
        recipe.setDishName(dishName);
        recipe.setPreparationNotes(preparationNotes);

        recipe = recipeRepository.save(recipe);

        List<IngredientEntity> ingredients = new ArrayList<>();

        for (int i = 0; i < ingName.length; i++) {

            IngredientEntity ing = new IngredientEntity();
            ing.setIngName(ingName[i]);
            ing.setIngUnit(ingUnit[i]);
            ing.setIngQty(ingQty[i]);
            ing.setIngNote(ingNote[i]);

            ing.setRecipe(recipe);

            ingredients.add(ing);
        }

        ingredientRepository.saveAll(ingredients);
    }
}
