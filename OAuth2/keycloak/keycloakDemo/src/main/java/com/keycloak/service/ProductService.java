package com.keycloak.service;

import org.springframework.stereotype.Service;
import com.keycloak.entity.Product;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {


    List<Product> productList= Arrays.asList(
            new Product("1234","mobile",9000.00),
            new Product("878974","laptop",68000.00),
            new Product("7896","tab",10000.00)
    );

    public List<Product> getProducts(){
        return this.productList;
    }

    public Product getProductbyId(String id){
       Product product= new Product("8334","product not exist",0000.00);
      return  productList.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(product);
    }
}
