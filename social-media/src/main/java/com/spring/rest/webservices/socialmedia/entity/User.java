package com.spring.rest.webservices.socialmedia.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@ApiModel(description = "User Model information")
public class User {

	private Integer id;

	@Size(min = 2, message = "Name should be atleast 2 characters.")
	@ApiModelProperty(notes = "Name must have atlease 2 characters.")
	private String name;

	@Past
	private Date birthDate;
	private String city;
	private String state;
	private String zipcode;
	
	public User(Integer id, String name, Date birthDate, String city, String state, String zipcode) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
	
	
}
