package com.hackathon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.dao.ProductDao;

@RestController
public class ProductController {
	
    @Autowired ProductDao productDao;
    
    @RequestMapping("/products/random")
    public String getProduct() {
        
        return productDao.getProduct("test").getTitle();
    }
    
    @RequestMapping("/products/query/{query}")
    public String getProduct(@PathVariable("query") String query) {
        
        
        
        return productDao.getProduct("test").getTitle();
    }
 }