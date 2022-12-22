package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.tb_user;
import com.example.demo.service.IUserService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	IUserService userService;
	
	@PostMapping("/insert")
	public tb_user insertUser(@RequestBody tb_user user) {
		return userService.insertUser(user);
	}
	
	@GetMapping("/getAll")
	public List<tb_user> getAll() {
		return userService.getAll();
	}
	
	@PostMapping("/login")
	public tb_user userLogin(@RequestBody tb_user user) {
		return userService.userLogin(user.getEmail(), user.getPassword());
	}

}
