package com.sportyshoes.webproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.webproject.model.Product;

@Service
public class ProductDAO {
	
	@Autowired
	ProductRepository prodRepo;
	
	public long count() {
		return prodRepo.count();
	}
	
	@SuppressWarnings("deprecation")
	public Product getById(int id) {
		return prodRepo.getById(id);
	}
	
	public List<Product> findAll(){
		return prodRepo.findAll();
	}
	
	public Product Save(Product prod) {
		return prodRepo.save(prod);
	}
	
	
	public Product Update(Product prod) {
		return prodRepo.save(prod);
	}
	
	public void Delete(Product prod) {
		prodRepo.delete(prod);
	}
	
	public void DeleteById(int id) {
		prodRepo.deleteById(id);
	}
}
