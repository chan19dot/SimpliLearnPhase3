package com.sportyshoes.webproject.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sportyshoes.webproject.model.Admin;
import com.sportyshoes.webproject.model.Product;
import com.sportyshoes.webproject.model.User;
import com.sportyshoes.webproject.service.AdminDAO;
import com.sportyshoes.webproject.service.AdminRepository;
import com.sportyshoes.webproject.service.ProductDAO;
import com.sportyshoes.webproject.service.UserDAO;

@Controller
public class MainController {
	
	@Autowired
	AdminDAO adminDao;
	
	@Autowired
	UserDAO userDao;
	
	@Autowired
	ProductDAO productDao;

    @RequestMapping(path="/", method = RequestMethod.GET)
    public String hello() {
        long a = adminDao.count();
        return "login";
    }
    
    @RequestMapping(path="/login")
    public ModelAndView login(HttpServletRequest req,HttpServletResponse res) {
    	ModelAndView mv = new ModelAndView();
    	String Adminname = req.getParameter("Aname");
    	String Adminpass = req.getParameter("Apass");
    	Admin ad= adminDao.findByAdmin(Adminname);
    	if(ad.getAdminpass().equals(Adminpass) ) {
    		mv.addObject("admin", ad);
    		mv.setViewName("hello");
    	}
    	else {
    		mv.setViewName("login");
    	}
    	return mv;
    	
    }
    
    @RequestMapping(path="admin/purchasereports")
    public ModelAndView SortingUsers(HttpServletRequest req,HttpServletResponse res) {
    	List<String> cat = userDao.findDistinctCategories();
    	ModelAndView mv = new ModelAndView();
    	mv.addObject("categories", cat);
    	mv.setViewName("filter");
    	return mv;
    }
    
    @RequestMapping(path="admin/purchasereports/sortedResults")
    public ModelAndView SortedUsers(HttpServletRequest req,HttpServletResponse res) {
    	String category = req.getParameter("category");
    	Date date = Date.valueOf(req.getParameter("date"));
    	ModelAndView mv = new ModelAndView();
    	List<User> list= userDao.findByCategoryAndDate(category, date);
    	
    	if(!list.isEmpty()) {
    		mv.addObject("ReportList", list);
        	mv.setViewName("Report");
    	}
    	else {
    		mv.setViewName("NoReports");
    	}
    	return mv;
    	
    }
    
    
    
    @RequestMapping(path="admin/allusers")
    public ModelAndView listOfUsers(HttpServletRequest req,HttpServletResponse res) {
    	ModelAndView mv = new ModelAndView();
    	List<User> l = userDao.findAll();
    	mv.addObject("listOfUsers", l);
    	mv.setViewName("allusers");
    	return mv;
    }
    
    @RequestMapping(path="admin/passwordchange")
    public ModelAndView passchange(HttpServletRequest req,HttpServletResponse res) {
    	ModelAndView mv = new ModelAndView();
    	mv.setViewName("passwordchange");
    	return mv;
    }
    
//    @ResponseBody ,@RequestParam String name
    @RequestMapping(path="admin/passchangevalidation")
    public ModelAndView passChangeValid(HttpServletRequest req,HttpServletResponse res) {
    	ModelAndView mv = new ModelAndView();
    	String oldp = req.getParameter("oldPassword");
    	String newp = req.getParameter("newPassword");
    	Admin adm = adminDao.findByPass(oldp);

    	if((newp.equals(oldp)) || (adm==null)) {
    		mv.setViewName("passwordChangeUnsuccess");
    	}
    	else {
    		adm.setAdminpass(newp);
    		adminDao.Update(adm);
    		mv.setViewName("passwordChangeSuccess");
    	}
    	return mv;
    }
    
    @RequestMapping(path="admin/manageproducts")
    public ModelAndView manageProducts(HttpServletRequest req,HttpServletResponse res) {
    	ModelAndView mv = new ModelAndView();
    	long c = productDao.count();
    	List<Product> products = productDao.findAll();
    	mv.addObject("products", products);
    	mv.setViewName("manageproducts");
    	return mv;
    }
    
    @RequestMapping(path="admin/manageproduct/edit")
    public String updateProducts(HttpServletRequest req,HttpServletResponse res, @RequestParam("id") String id) {
    	int id1 = Integer.parseInt(id);
    	Product prod = productDao.getById(id1);
    	return "editProduct";
    }
    
    @RequestMapping(path="admin/manageproduct/editsub")
    public ModelAndView editprod(HttpServletRequest req,HttpServletResponse res) {
    	String id1 = req.getParameter("id");
    	int id = Integer.parseInt(id1);
    	String name =req.getParameter("name");
    	String category = req.getParameter("category");
    	String quant = req.getParameter("quantity");
    	int quantity = Integer.parseInt(quant);
    	double price = Integer.parseInt(req.getParameter("price"));
    	Product prod= productDao.getById(id);
    	prod.setCategory(category);
    	prod.setPrice(price);
    	prod.setQuantity(quantity);
    	prod.setShoename(name);
    	productDao.Update(prod);
    	ModelAndView mv = new ModelAndView();
    	mv.addObject("product",prod);
    	mv.setViewName("prodAddedSuccesfully");
    	return mv;
    }
    @RequestMapping(path="admin/manageproduct/delete")
    public ModelAndView Deleteprod(HttpServletRequest req,HttpServletResponse res, @RequestParam("id") String id) {
    	int id1 = Integer.parseInt(id);
    	productDao.DeleteById(id1);
    	ModelAndView mv = new ModelAndView();
    	mv.setViewName("prodAddedSuccesfully");
    	return mv;
    }
    @RequestMapping(path="admin/manageproduct/add")
    public ModelAndView AddProd(HttpServletRequest req,HttpServletResponse res) {
    	ModelAndView mv = new ModelAndView();
    	mv.setViewName("ProdAdd");
    	return mv;
    }
    @RequestMapping(path="admin/manageproduct/NewProduct")
    public ModelAndView NewProd(HttpServletRequest req,HttpServletResponse res) {
    	int id = (int) productDao.count() + 1;
    	String name =req.getParameter("name");
    	String category = req.getParameter("category");
    	String quant = req.getParameter("quantity");
    	int quantity = Integer.parseInt(quant);
    	double price = Integer.parseInt(req.getParameter("price"));
    	Product prod = new Product();
    	prod.setProductid(id);
    	prod.setCategory(category);
    	prod.setPrice(price);
    	prod.setQuantity(quantity);
    	prod.setShoename(name);
    	productDao.Save(prod);
    	ModelAndView mv = new ModelAndView();
    	mv.setViewName("prodAddedSuccesfully");
    	return mv;
    }
    
    

}
