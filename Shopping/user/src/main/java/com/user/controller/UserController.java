package com.user.controller;

import com.user.dto.AddressDto;
import com.user.dto.ResponseDto;
import com.user.dto.UserDto;
import com.user.entity.User;
import com.user.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.sql.Date;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<ResponseDto> createUser(@RequestBody UserDto user, HttpServletRequest request) {

        userService.saveUser(user);
        ResponseDto responseDto = new ResponseDto(200, "user registered !", "success", HttpStatus.CREATED.toString(), request.getRequestURI(), LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @PostMapping("/{userId}")
    public ResponseEntity<ResponseDto> addAddressToUserbyId(@RequestBody AddressDto dto, @PathVariable long userId, WebRequest request) {
        userService.addAddress(dto, userId);
        ResponseDto responseDto = new ResponseDto(200, "user registered !", "success", HttpStatus.CREATED.toString(), request.getContextPath(), LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @GetMapping("/mobileNo/{mobileNo}")
    public ResponseEntity<UserDto> findUserBYMobile(@PathVariable long mobileNo) {
        UserDto user = this.userService.findUserbyMobileNo(mobileNo);
        return ResponseEntity.ok(user);
    }

    @PatchMapping
    public ResponseEntity<UserDto> updateMobileNumber(@RequestBody User user,@RequestParam long mobileNo){
        UserDto user1=this.userService.findUserbyMobileNo(user.getMobileNo());
        user1.setMobileNo(mobileNo);
        UserDto mappedUser = this.modelMapper.map(user1, UserDto.class);
        this.userService.updateUser(mappedUser);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(mappedUser);
    }

}
