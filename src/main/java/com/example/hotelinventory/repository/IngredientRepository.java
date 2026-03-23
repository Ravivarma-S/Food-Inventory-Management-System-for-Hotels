package com.example.hotelinventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hotelinventory.model.IngredientEntity;
import com.example.hotelinventory.model.StocksEntity;

public interface IngredientRepository extends JpaRepository<IngredientEntity, Long> {
	List<IngredientEntity> findByRecipeId(Long recipeId);

}
