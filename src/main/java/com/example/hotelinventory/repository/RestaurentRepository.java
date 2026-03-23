package com.example.hotelinventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hotelinventory.model.RestaurentEntity;



@Repository
public interface RestaurentRepository extends JpaRepository<RestaurentEntity, Long>{

	RestaurentEntity findByEmailAndPassword(String email, String password);

}
