package com.hackathon.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.hackathon.datamodel.Product;

@Repository
public class ProductDaoImpl implements ProductDao{
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Transactional
    public List<Product> getRandomProducts() throws DataAccessException{
        CriteriaQuery<Product> cq = entityManager.getCriteriaBuilder().createQuery(Product.class);
        Root<Product> root = cq.from(Product.class);
        cq.select(root);
        List<Product> resultList = entityManager.createQuery(cq).getResultList();
        return resultList;
    }

    @Transactional
    public List<Product> searchProducts(String searchTerm) throws DataAccessException{
    	String glMatch = "gl_" + searchTerm;
    	String searchPattern = "%" + searchTerm +"%";
    	CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    	CriteriaQuery<Product> cq = cb.createQuery(Product.class);
    	Root<Product> root = cq.from(Product.class);
    	cq.select(root);
    	cq.where(cb.or(cb.like(root.<String>get("title"), searchPattern), cb.equal(root.<String>get("productGl"), glMatch)));
    	List<Product> resultList = entityManager.createQuery(cq).getResultList();
    	
    	return resultList;
    }
}
