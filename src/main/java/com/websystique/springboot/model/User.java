package com.websystique.springboot.model;

public class User {
	
	private long id;
	private String name;
	private int salary;
	
	public User(){}
	
	public User( String name, int salary ) {
		
		this.name = name;
		this.salary = salary;
	}
	
	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
}
