package com.example.demo.jpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.jpa.entity.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
