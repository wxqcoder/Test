package com.test;

import java.util.ArrayList;
import java.util.List;

public class Person {

	private String name;
	
	private List<ChildBean> list = new ArrayList<ChildBean>();
	
	private int num;
	
	private String sex;
	
	private int age;
	
	public Person() {
	
	}
	
	public Person(String name, int num, String sex, int age) {
	    super();
	    this.name = name;
	    this.num = num;
	    this.sex = sex;
	    this.age = age;
	}
	
	public int getAge() {
	    return age;
	}
	
	public String getName() {
	    return name;
	}
	
	public int getNum() {
	    return num;
	}
	
	public String getSex() {
	    return sex;
	}
	
	public void setAge(int age) {
	    this.age = age;
	}
	
	public void setName(String name) {
	    this.name = name;
	}
	
	public void setNum(int num) {
	    this.num = num;
	}
	
	public void setSex(String sex) {
	    this.sex = sex;
	}
	
	public List<ChildBean> getList() {
	    return list;
	}
	
	public void setList(List<ChildBean> list) {
	    this.list = list;
	}
	
	public String toString() {
	    return "Person [name=" + name + ", num=" + num + ", sex=" + sex + ", age=" + age + ",list=" + list + "]";
	}
	
}