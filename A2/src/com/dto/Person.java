package com.dto;

public class Person {
private String name;
private int id;
@Override
public String toString() {
	return "Person [name=" + name + ", id=" + id + "]";
}
public Person() {
	super();
	// TODO Auto-generated constructor stub
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

}
