package com.example.demo.jpa.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.jpa.entity.UserEntity;
/**
 * 用户Dao操作
 * @author Administrator
 *
 */
public interface UserDao extends CrudRepository<UserEntity, Integer> {
	public List<UserEntity> findByName(String name);  
    public List<UserEntity> findByAge(Integer age);  
}
