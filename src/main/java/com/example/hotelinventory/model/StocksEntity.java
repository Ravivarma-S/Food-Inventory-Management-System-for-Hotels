package com.example.hotelinventory.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Stocks")
public class StocksEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String productName;
    private String unit;
    private String quantity;
    private String reorderLevel;
    private String expiryDate;
    
    
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getReorderLevel() {
		return reorderLevel;
	}
	public void setReorderLevel(String reorderLevel) {
		this.reorderLevel = reorderLevel;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	
	
	
	public StocksEntity() {
		super();
		this.id = id;
		this.productName = productName;
		this.unit = unit;
		this.quantity = quantity;
		this.reorderLevel = reorderLevel;
		this.expiryDate = expiryDate;
	}
	
	
	
	@Override
	public String toString() {
		return "StocksEntity [id=" + id + ", productName=" + productName + ", unit=" + unit + ", quantity=" + quantity
				+ ", reorderLevel=" + reorderLevel + ", expiryDate=" + expiryDate + "]";
	}
    
    
    

	
	
}
