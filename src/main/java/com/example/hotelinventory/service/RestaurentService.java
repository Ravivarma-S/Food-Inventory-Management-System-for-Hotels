package com.example.hotelinventory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.hotelinventory.dto.RestaurentDTO;
import com.example.hotelinventory.dto.StocksDTO;
import com.example.hotelinventory.model.RestaurentEntity;
import com.example.hotelinventory.model.StocksEntity;
import com.example.hotelinventory.repository.RestaurentRepository;
import com.example.hotelinventory.repository.StocksRepository;



@Service
public class RestaurentService {

	@Autowired
	private RestaurentRepository restaurentRepository;
	
	
	@Autowired
	private StocksRepository stocksRepository;
	
	 public RestaurentEntity saveRestaurent(RestaurentDTO dto) {
	    	
	    	
			

		 	RestaurentEntity restaurent= new RestaurentEntity();
		 	restaurent.setFullname(dto.getFullname());
		 	restaurent.setEmail(dto.getEmail());
		 	restaurent.setBrand(dto.getBrand());
		 	restaurent.setContact(dto.getContact());
		 	restaurent.setPassword(dto.getPassword());
		  
		    
	    	
	        return restaurentRepository.save(restaurent);
	    }
	 
	 
	 public RestaurentEntity validateRestaurentLogin(String email, String password) {
	        
	        return restaurentRepository.findByEmailAndPassword(email, password);
	    }


	 
	 public StocksEntity saveStocks(StocksDTO dto) {

		 
		    Optional<StocksEntity> existingStock =
		            stocksRepository.findByProductNameIgnoreCase(dto.getProductName());

		    if (existingStock.isPresent()) {

		       
		        StocksEntity stock = existingStock.get();

		        double oldQty = Double.parseDouble(stock.getQuantity());
		        double newQty = Double.parseDouble(dto.getQuantity());

		        double updatedQty = oldQty + newQty;

		        stock.setQuantity(String.valueOf(updatedQty));

		        
		        if (dto.getExpiryDate() != null && !dto.getExpiryDate().isEmpty()) {
		            stock.setExpiryDate(dto.getExpiryDate());
		        }

		        return stocksRepository.save(stock);

		    } else {

		       
		        StocksEntity stock = new StocksEntity();
		        stock.setProductName(dto.getProductName());
		        stock.setUnit(dto.getUnit());
		        stock.setQuantity(dto.getQuantity());
		        stock.setReorderLevel(dto.getReorderLevel());
		        stock.setExpiryDate(dto.getExpiryDate());

		        return stocksRepository.save(stock);
		    }
		}


	 public List<StocksEntity> getAllStocks() {
		
		return stocksRepository.findAll();
		
		
	 }


	 
	 public StocksEntity getStockById(Long id) {

	        Optional<StocksEntity> optionalStock = stocksRepository.findById(id);

	        if (optionalStock.isPresent()) {
	            return optionalStock.get();
	        } else {
	            throw new RuntimeException("Stock not found with id: " + id);
	        }
	    }

	 public void deleteStock(Long id) {

	        if (stocksRepository.existsById(id)) {
	            stocksRepository.deleteById(id);
	        } else {
	            throw new RuntimeException("Stock not found with id: " + id);
	        }
	    }


	 public StocksEntity updateStocks(StocksDTO dto) {

		  
		    StocksEntity stock = stocksRepository.findById(dto.getId())
		            .orElseThrow(() -> new RuntimeException("Stock not found"));

		   
		    stock.setProductName(dto.getProductName());
		    stock.setUnit(dto.getUnit());
		    stock.setQuantity(dto.getQuantity());
		    stock.setReorderLevel(dto.getReorderLevel());
		    stock.setExpiryDate(dto.getExpiryDate());

		   
		    return stocksRepository.save(stock);
		}
        
	 
	

}
