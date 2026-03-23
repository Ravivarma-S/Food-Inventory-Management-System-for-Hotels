package com.example.hotelinventory.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Restaurent")
public class RestaurentEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String fullname;
    private String email;
    private String brand;
    private String contact;
    private String password;
    
    
    
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	public RestaurentEntity() {
		super();
		this.id = id;
		this.fullname = fullname;
		this.email = email;
		this.brand = brand;
		this.contact = contact;
		this.password = password;
	}
	
	
	
	
	@Override
	public String toString() {
		return "RestaurentEntity [id=" + id + ", fullname=" + fullname + ", email=" + email + ", brand=" + brand
				+ ", contact=" + contact + ", password=" + password + "]";
	}
    
    
    
    
	

}
