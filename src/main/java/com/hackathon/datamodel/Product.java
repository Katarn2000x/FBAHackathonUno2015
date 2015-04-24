package com.hackathon.datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Product")
public class Product {
    @Id
    @Column(name="ASIN")
    private String asin;
    @Column(name="ITEM_NAME")
    private String title;
    @Column(name = "MSRP")
    private String price;
    @Column(name = "GL_PRODUCT_GROUP_DESC")
    private String productGl;
    @Column(name = "CUSTOMER_ACTIVE_REVIEW_COUNT")
    private String reviewCount;
    @Column(name = "CUST_AVG_ACTIVE_REVIEW_RATING")
    private String reviewRating;
    
    public void setAsin(String asin){
        this.asin = asin;
    }
    public String getAsin(){
        return this.asin;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return this.title;
    }
    public void setPrice(String price){
        this.price = price;
    }
    public String getPrice(){
        return this.price;
    }
    public void setProductGl(String productGl){
        this.productGl = productGl;
    }
    public String getProductGl(){
        return this.productGl;
    }
    public void setReviewCount(String reviewCount){
        this.reviewCount = reviewCount;
    }
    public String getReviewCount(){
        return this.reviewCount;
    }
    public void setReviewRating(String reviewRating){
        this.reviewRating = reviewRating;
    }
    public String get(){
        return this.reviewRating;
    }
}
