package com.telusko.ProductSpringWeb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductDB db;
    List<Product> products = new ArrayList<>();

    public void addProduct(Product p){
//        products.add(p);

        db.save(p);

    }
//
    public List<Product> getAllProducts(){

        return db.findAll();
    }
//
    public Product getProduct(String name){
        return db.findByName(name);
    }
    public List<Product> getProductWithText(String text) {
        String str = text.toLowerCase();
        List<Product> prods = new ArrayList<>();

        for(Product p : products){
            String name = p.getName().toLowerCase();
            String type = p.getType().toLowerCase();
            String place = p.getPlace().toLowerCase();
            if(name.contains(str) || type.contains(str) || place.contains(str))
                prods.add(p);
        }

        return prods;
    }
}
