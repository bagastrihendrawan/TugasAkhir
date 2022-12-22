package com.example.demo.repository;



import java.util.List;

import com.example.demo.model.tb_user;

public interface IUserRepository {
	public tb_user insertUser(tb_user user);
	public List<tb_user> getAll();
	public tb_user userLogin(String email,String password);

}
