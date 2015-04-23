package com.hackathon.datamodel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Product")
public class Product {
    @Id
    private String asin;
    private String title;
    private String price;
    private String imageUrl;
    private String productGl;
    
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
    public void setImageUrl(String imageUrl){
        this.imageUrl = imageUrl;
    }
    public String getImageUrl(){
        return this.imageUrl;
    }
    public void setProductGl(String productGl){
        this.productGl = productGl;
    }
    public String getProductGl(){
        return this.productGl;
    }
}
