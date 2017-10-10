package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dangdang.ddframe.rdb.sharding.id.generator.IdGenerator;
import com.example.demo.jpa.dao.OrderRepository;
import com.example.demo.jpa.entity.Order;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private IdGenerator idGenerator;
    
    @RequestMapping("/add")
    public Object add() {
        for (int i = 0; i < 10; i++) {
            Order order = new Order();
            order.setUserId((long) i);
            order.setOrderId((long) i);
            orderRepository.save(order);
        }
        for (int i = 10; i < 20; i++) {
            Order order = new Order();
            order.setUserId((long) i + 1);
            order.setOrderId((long) i);
            orderRepository.save(order);
        }
        return "success";
    }
    @RequestMapping("/add_id_generator")
    public Object add_id_generator() {
    	 Order order = new Order();
         order.setUserId(1L);
         order.setOrderId(idGenerator.generateId().longValue());
         orderRepository.save(order);
         return "success";
    }

    @RequestMapping("query")
    private Object queryAll() {
        return orderRepository.findAll();
    }
}
