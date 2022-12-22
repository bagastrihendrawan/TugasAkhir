package com.example.demo.service.impl;


import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.tb_user;
import com.example.demo.repository.IUserRepository;
import com.example.demo.service.IUserService;

@Service
public class UserService implements IUserService {
	
	@Autowired
	IUserRepository userRepository;

	@Override
	public tb_user insertUser(tb_user user) {
		// TODO Auto-generated method stub
		return userRepository.insertUser(user);
	}

	@Override
	public List<tb_user> getAll() {
		// TODO Auto-generated method stub
		return userRepository.getAll();
	}

	@Override
	public tb_user userLogin(String email, String password) {
		// TODO Auto-generated method stub
		return userRepository.userLogin(email, password);
	}


}
