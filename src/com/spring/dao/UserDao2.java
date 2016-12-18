package com.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.spring.vo.User;

@Repository
public class UserDao2 extends JdbcDaoSupport{

	@Autowired
	public void setTemplate(JdbcTemplate template) {
		setJdbcTemplate(template);
	}

	
	public User getUserById(int userId){
		String sql = " select * from User where id = ? ";
		return getJdbcTemplate().queryForObject(sql, new BeanPropertyRowMapper<>(User.class), userId);
	}
	
}
