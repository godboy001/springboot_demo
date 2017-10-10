package com.example.demo.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  
@Table(name = "t_user")
public class UserEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4803479483269723015L;
	@Id  
    @GeneratedValue(strategy = GenerationType.AUTO)  
    private int id; 
	@Column(name = "name", nullable = true, length = 50)
	private String name;
	@Column(name = "age", nullable = true, length = 11)  
	private Integer age;
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
}
