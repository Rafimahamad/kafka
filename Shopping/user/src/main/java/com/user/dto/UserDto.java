package com.user.dto;

import com.user.entity.Address;
import com.user.entity.Item;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private long userId;
    private String name;
    private String emailId;
    private Long mobileNo;
    private List<AddressDto> address=new LinkedList<>();

    private List<Item> items=new LinkedList<>();

}
