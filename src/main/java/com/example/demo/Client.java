package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity
@Table(name="client")

public class Client {

	@javax.persistence.Id
	@GeneratedValue
	private Long Id;
	
	private String name;
	
	private String email;	
	
	public void client() {}
	

	// getter, setters, contructors
	public Long getId() {
		return Id;
	}	

	public void setId(Long id) {
		Id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

}
