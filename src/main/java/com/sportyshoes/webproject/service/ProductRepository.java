package com.sportyshoes.webproject.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sportyshoes.webproject.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	

}
