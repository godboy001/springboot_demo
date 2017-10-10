package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.jpa.dao.UserDao;
import com.example.demo.jpa.entity.UserEntity;

@Controller
public class UserController {
 @Autowired  
    private UserDao userDao;  
 
	@RequestMapping("/index")
	public String test(){
		return "index";
	}
	
	@RequestMapping("/getByName")  
    @ResponseBody  
    public String getByName(String name) {  
        List<UserEntity> userList = userDao.findByName(name);  
        if (userList != null && userList.size()!=0) {  
            return "The user length is: " + userList.size();  
        }  
        return "user " + name + " is not exist.";  
    }  
	
}
