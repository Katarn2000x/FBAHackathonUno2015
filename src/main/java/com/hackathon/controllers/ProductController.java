package com.hackathon.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.dao.ProductDao;
import com.hackathon.datamodel.Product;

@RestController
public class ProductController {
	
    @Autowired ProductDao productDao;
    
    @RequestMapping("/products/random")
    public ResponseEntity<List<Product>> getRandomProduct() {
        
        return new ResponseEntity<List<Product>>(productDao.getRandomProducts(), HttpStatus.OK);
    }
    
    @RequestMapping("/products/query/{query}")
    public ResponseEntity<List<Product>> searchProducts(@PathVariable("query") String query) {
        return new ResponseEntity<List<Product>>(productDao.searchProducts(query), HttpStatus.OK);
    }
 }