package com.sportyshoes.webproject.service;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sportyshoes.webproject.model.Admin;

@Primary
public interface AdminRepository extends JpaRepository<Admin, Integer> {
	
	@Query("select admin from Admin admin where admin.adminname=?1")
	public Admin findByAdmin(String aname);
	
	@Query("select admin from Admin admin where admin.adminpass=?1")
	public Admin findByPass(String pass);	

}
