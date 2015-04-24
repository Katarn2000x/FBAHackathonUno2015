package com.hackathon.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.hackathon.datamodel.Product;

@Repository
public class ProductDaoImpl implements ProductDao{
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @SuppressWarnings("unchecked")
    @Transactional
    public List<Product> getProducts() throws DataAccessException {
        Query query = entityManager.createQuery("select p from Product p");
        List<Product> resultList = query.getResultList();
        return resultList;
    }
    @Transactional
    public Product getProduct(String asin) throws DataAccessException {
        return entityManager.find(Product.class, asin);
    }    
}
