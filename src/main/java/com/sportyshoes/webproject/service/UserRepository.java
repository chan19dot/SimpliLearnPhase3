package com.sportyshoes.webproject.service;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sportyshoes.webproject.model.User;


public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query(value="select distinct category from productdetails", nativeQuery=true)
	public List<String> findDistinctCategories();
	
	@Query(value="SELECT * FROM userdetails WHERE category LIKE (?1) AND dateofpurchase = (?2)", nativeQuery=true)
	public List<User> findByCategoryAndDate(String Category, Date date);

}
