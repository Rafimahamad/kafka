package com.keycloak.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {

    String id;
    String name;
    double price;

}
