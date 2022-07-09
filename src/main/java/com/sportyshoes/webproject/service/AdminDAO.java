package com.sportyshoes.webproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.webproject.model.Admin;

@Service
public class AdminDAO {
	
	@Autowired
	AdminRepository adminRepo;
	
	public Admin findByAdmin(String aname) {
		return(adminRepo.findByAdmin(aname));
	}
	
	public long count() {
		return adminRepo.count();
	}
	
	public Admin findByPass(String pass) {
		return adminRepo.findByPass(pass);
	}
	
	public Admin Update(Admin adm) {
		return adminRepo.save(adm);
	}
	
	public Admin save(Admin adm) {
		return adminRepo.save(adm);
	}

}
