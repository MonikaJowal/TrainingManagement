package com.hcl.userfoodmanagement.beans;

import java.util.Set;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
@Entity
@NamedQuery(name="User.findAll", query="SELECT e FROM User e")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long user_id;
	private String first_name;
	private String last_name;
	private String mobile_no;
	private String email_id;
	@OneToMany(mappedBy = "user_details")
	private Set<Food> food_menu;
	
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public Set<Food> getFood_menu() {
		return food_menu;
	}
	public void setFood_menu(Set<Food> food_menu) {
		this.food_menu = food_menu;
	}
	

}
