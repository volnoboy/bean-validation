package com.volnoboy.model;

import java.util.Date;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Past;

import com.volnoboy.validator.FirstCapital;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Range;

/**
 * @author Volodymyr Volnoboy
 * @since 3/1/16 5:08 PM
 */
public class User {

	@FirstCapital
	private String name;

	@FirstCapital
	private String lastName;

	@Past
	private Date dateOfBirth;

	@Range(min = 13, max = 30)
	private int age;

	@Email
	private String email;

	private boolean isMarried;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@AssertTrue
	public boolean isMarried() {
		return isMarried;
	}

	public void setIsMarried(boolean isMarried) {
		this.isMarried = isMarried;
	}

	public User(String name, String lastName, Date dateOfBirth, int age, String email, boolean isMarried) {
		this.name = name;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.age = age;
		this.email = email;
		this.isMarried = isMarried;
	}
}
