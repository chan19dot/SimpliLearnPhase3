package com.sportyshoes.webproject.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.webproject.model.User;

@Service
public class UserDAO {
	@Autowired
	UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();
	}
	public List<String> findDistinctCategories(){
		return repo.findDistinctCategories();
		
	}
	
	public List<User> findByCategoryAndDate(String Category, Date date){
		List<User> l=repo.findByCategoryAndDate(Category, date);
		if(l !=null) {
			return l;
		}
		else {
			return new ArrayList<>();
		}
	}
}
