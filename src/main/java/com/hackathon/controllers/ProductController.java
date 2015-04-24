package com.hackathon.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	
	@RequestMapping("/product")
	public String getProduct(@RequestParam(value="name", defaultValue="Ryan") String name) {
		return "IT WORKS";
	}
 }