package com.kafka.entity;

import lombok.Data;

@Data
public class User {
    int id;
    String name;
    String email;
    long mobileNo;
}
