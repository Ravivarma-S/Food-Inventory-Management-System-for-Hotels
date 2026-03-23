package com.example.hotelinventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hotelinventory.model.RecipeEntity;

public interface RecipeRepository extends JpaRepository<RecipeEntity, Long> {
	RecipeEntity findByDishName(String dishName);

}
