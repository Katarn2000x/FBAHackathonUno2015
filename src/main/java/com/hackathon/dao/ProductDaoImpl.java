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
    public List<Product> getRandomProducts() throws DataAccessException{
        Query query = entityManager.createQuery("select p from Product limit 18");
        List<Product> resultList = query.getResultList();
        return resultList;
    }

    @SuppressWarnings("unchecked")
    @Transactional
    public List<Product> searchProducts(String searchTerm) throws DataAccessException{
        Query query = entityManager.createQuery(
                "select p from Product where title like '%" + searchTerm + "%'");
        List<Product> resultList = query.getResultList();
        return resultList;
    }
}
