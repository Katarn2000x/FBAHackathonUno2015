package com.hackathon.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.hackathon.datamodel.Product;

public interface ProductDao {
    public List<Product> getProducts() throws DataAccessException;
    public Product getProduct(String asin) throws DataAccessException;
}
