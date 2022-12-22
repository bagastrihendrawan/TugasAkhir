package com.example.demo.repository.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.tb_user;
import com.example.demo.repository.IUserRepository;

@Repository
public class UserRepository implements IUserRepository{
	@Autowired
	JdbcTemplate jdbcTemplate;


	@Override
	public tb_user insertUser(tb_user user) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				String query = "INSERT INTO tb_user(email, nama, password) " 
						+ "VALUES(?, ?, ?)";
				jdbcTemplate.update(query, new Object[] {user.getEmail(), user.getNama(), user.getPassword()});
				return user;
			}


	@Override
	public List<tb_user> getAll() {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM tb_user";
		return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(tb_user.class));
	}


	@Override
	public tb_user userLogin(String email, String password) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM tb_user WHERE email = ? AND password = ?";
		return jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(tb_user.class),email,password);
	}


}
