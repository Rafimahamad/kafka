package com.keycloak.controller;

import com.keycloak.entity.Product;
import com.keycloak.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/api/v1/products")
@CrossOrigin("*")
public class ProductController {

    private final ProductService service;

   @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.status(200).body(service.getProducts());
    }

    @GetMapping(params = "id")
    ResponseEntity<Product> getProductByItsId(@RequestParam String id){
       return ResponseEntity.ok(service.getProductbyId(id));
    }



}
