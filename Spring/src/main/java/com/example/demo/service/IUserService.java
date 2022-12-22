package com.example.demo.service;



import java.util.List;

import com.example.demo.model.tb_user;

public interface IUserService {

	public tb_user insertUser(tb_user user);
	public List<tb_user> getAll();
	public tb_user userLogin(String email, String password);

}
