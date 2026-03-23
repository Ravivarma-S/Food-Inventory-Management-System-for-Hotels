package com.example.hotelinventory.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hotelinventory.model.IngredientEntity;
import com.example.hotelinventory.model.StocksEntity;

@Repository
public interface StocksRepository extends JpaRepository<StocksEntity, Long>{

	Optional<StocksEntity> findByProductNameIgnoreCase(String productName);


	void save(Optional<StocksEntity> stock);

	StocksEntity findByProductName(String productName);


}
