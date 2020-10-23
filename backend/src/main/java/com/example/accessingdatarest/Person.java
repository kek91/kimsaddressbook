package com.otrum.kimsaddressbook;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String name;
	// private String lastName;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// public String getFirstName() {
	// 	return firstName;
	// }

	// public void setFirstName(String firstName) {
	// 	this.firstName = firstName;
	// }

	// public String getLastName() {
	// 	return lastName;
	// }

	// public void setLastName(String lastName) {
	// 	this.lastName = lastName;
	// }

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
