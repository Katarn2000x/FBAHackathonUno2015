package com.hackathon.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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

    @SuppressWarnings("unchecked")
    @Transactional
    public List<Product> searchProducts(String searchTerm) throws DataAccessException{
        try{
            Query query = entityManager.createQuery(
                    "select p from Product where ITEM_NAME like '%" + searchTerm + "%' or GL_PRODUCT_GROUP_DESC='gl_" + searchTerm + "'");
            List<Product> resultList = query.getResultList();
            return resultList;
        }catch (Exception exception){
            return new ArrayList<Product>();
        }
    }
}
