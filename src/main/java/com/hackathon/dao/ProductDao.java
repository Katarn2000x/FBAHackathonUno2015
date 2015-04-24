package com.hackathon.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.hackathon.datamodel.Product;

public interface ProductDao {
    public List<Product> getRandomProducts() throws DataAccessException;
    public List<Product> searchProducts(String asin) throws DataAccessException;
}
