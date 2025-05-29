package com.user.service;

import com.user.dto.AddressDto;
import com.user.dto.UserDto;
import com.user.entity.User;

import java.util.Optional;

public interface UserService {
    void saveUser(UserDto user);

    User updateUser(UserDto user);

    void deleteUserbyId(long userId);

    UserDto findUserbyMobileNo(long mobileNo);


    Optional<User> findUserById(long id);

    void addAddress(AddressDto addressDto, long userId);
}
