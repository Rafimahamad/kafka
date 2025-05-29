package com.user.service.serviceImpl;

import com.user.dto.AddressDto;
import com.user.dto.UserDto;
import com.user.entity.Address;
import com.user.entity.Item;
import com.user.entity.User;
import com.user.exception.UserNotFoundException;
import com.user.repository.UserRepo;
import com.user.service.UserService;
import com.user.service.external.ItemService;
import feign.FeignException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ItemService itemService;

    @Override
    public void saveUser(UserDto userDto) {
        String s = UUID.randomUUID().toString().replaceAll("[^0-9]", "");
        String substring = s.substring(0, 9);
        Long userId = Long.parseLong(substring);

        User user = modelMapper.map(userDto, User.class);
        user.setUserId(userId);
        System.out.println(user);

        userRepo.save(user);

    }

    @Override
    public User updateUser(UserDto user) {

        User user1 = this.userRepo.findById(user.getUserId()).orElseThrow(() -> new UserNotFoundException("user not found !"));
        User updatedUser = this.userRepo.save(user1);
        return updatedUser;
    }

    @Override
    public void deleteUserbyId(long userId) {

    }


    @Override
    public UserDto findUserbyMobileNo(long mobileNo) {
       User user = this.userRepo.findUserByMobileNo(mobileNo).orElseThrow(()->new UserNotFoundException("user NOt found with this mobile Number !"));
        UserDto userDto = this.modelMapper.map(user, UserDto.class);
        List<Item> allItems=new LinkedList<>();
        try{
         allItems= itemService.getAllItems();

         userDto.setItems(allItems);
     } catch (FeignException e) {
            System.out.println("Exception --------------------");
         e.getStackTrace();

         System.out.println(e.getMessage());
     }
        System.out.println("items : "+allItems);
        System.out.println(userDto);

        return userDto;
    }



    @Override
    public Optional<User> findUserById(long id) {
        Optional<User> user = this.userRepo.findById(id);
        if (user.isPresent()) {
            return user;
        } else
            throw new UserNotFoundException("user NOt Found !");

    }

    @Override
    public void addAddress(AddressDto addressDto, long userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new UserNotFoundException("user Not Found !"));

        user.setAddress((List<Address>) addressDto);
this.userRepo.save(user);
    }
}
