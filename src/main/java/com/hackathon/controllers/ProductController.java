package com.hackathon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.dao.ProductDao;
import com.hackathon.dao.ProductDaoImpl;

@RestController
public class ProductController {
	
    @Autowired ProductDao productDao;
    
	@RequestMapping("/product")
	public String getProduct(@RequestParam(value="name", defaultValue="Ryan") String name) {
	    
		return productDao.getProduct("test").getTitle();
	}
 }