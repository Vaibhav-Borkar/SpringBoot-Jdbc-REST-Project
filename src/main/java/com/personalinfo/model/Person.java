package com.personalinfo.model;


public class Person {
	private int id;
	private String name;
	private String company;
	private int salary;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Person(int id, String name, String company, int salary) {
		this.id = id;
		this.name = name;
		this.company = company;
		this.salary = salary;
	}
	public Person() {
		super();
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", company=" + company + ", salary=" + salary + "]";
	}
	
	
}
