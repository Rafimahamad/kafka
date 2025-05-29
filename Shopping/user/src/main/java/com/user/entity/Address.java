package com.user.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Address {
    private String id;
    private String street;
    private String landmark;
    private String district;
    private String state;
    private String country;
    private int pincode;



}
