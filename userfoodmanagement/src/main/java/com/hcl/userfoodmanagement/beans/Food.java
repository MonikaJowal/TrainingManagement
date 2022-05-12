package com.hcl.userfoodmanagement.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
@Entity
@NamedQuery(name="Food.findAll", query="SELECT e FROM Food e")
public class Food {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long food_id;
	private String food_name;
	private Double food_price;
	
	@ManyToOne
	private User user_details;
	
	public Long getFood_id() {
		return food_id;
	}
	public void setFood_id(Long food_id) {
		this.food_id = food_id;
	}
	public String getFood_name() {
		return food_name;
	}
	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}
	public User getUser_details() {
		return user_details;
	}
	public void setUser_details(User user_details) {
		this.user_details = user_details;
	}
	
	public Double getFood_price() {
		return food_price;
	}
	public void setFood_price(Double food_price) {
		this.food_price = food_price;
	}
	
}
